from fastapi import FastAPI
from pydantic import BaseModel

from database import get_db, create_tables
from models import Base, Event, User, EventAdmin, Registration

app = FastAPI()

@app.get("/")
def read_root():
    return {"Hello": "World"}

@app.get("/items/{item_id}")
def read_item(item_id: int, q: str = None):
    return {"item_id": item_id, "q": q}

@app.on_event("startup")
def create_default_config():
    # Create the database tables
    create_tables()
    db: Session = next(get_db())

    try:
        # Check if the admin user already exists
        admin_user = db.query(User).filter_by(username="admin").first()

        if not admin_user:
            # Create the admin user
            admin = User(username="admin", password="password", role="admin", email="admin@placeholder.com")
            db.add(admin)
            db.commit()
    except IntegrityError:
        # Handle any integrity errors, such as duplicate admin creation
        db.rollback()
    finally:
        # Close the session
        db.close()
