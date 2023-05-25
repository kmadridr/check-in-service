from fastapi import FastAPI
from pydantic import BaseModel

from database import get_db, create_tables
from models import Base, Event, User, EventAdmin, Registration

class EventDTO(BaseModel):
    event_name: str
    location: str
    event_date: str
    capacity: int
    price: float
    image: str

class UserDTO(BaseModel):
    username: str
    email: str
    password: str
    role: str
    full_name: str
    phone_number: str
    address: str

class RegistrationDTO(BaseModel):
    event_id: int
    user_id: int
    payment_status: str
    amount_paid: float

class EventAdminDTO(BaseModel):
    event_id: int
    admin_id: int

app = FastAPI()

@app.get("/")
def read_root():
    return {"Hello": "World"}

@app.get("/items/{item_id}")
def read_item(item_id: int, q: str = None):
    return {"item_id": item_id, "q": q}

@app.get("/events")
def get_events():
    db = next(get_db())
    events = db.query(Event).all()
    return events

@app.get("/events/{event_id}")
def get_event(event_id: int):
    db = next(get_db())
    event = db.query(Event).filter_by(id=event_id).first()
    return event

@app.post("/events")
def create_event(event: EventDTO):
    db = next(get_db())
    db.add(event)
    db.commit()
    return event

@app.put("/events/{event_id}")
def update_event(event_id: int, event: EventDTO):
    db = next(get_db())
    db.query(Event).filter_by(id=event_id).update(event)
    db.commit()
    return event

@app.delete("/events/{event_id}")
def delete_event(event_id: int):
    db = next(get_db())
    db.query(Event).filter_by(id=event_id).delete()
    db.commit()
    return {"message": "Event deleted successfully"}

@app.get("/users")
def get_users():
    db = next(get_db())
    users = db.query(User).all()
    return users

@app.get("/users/{user_id}")
def get_user(user_id: int):
    db = next(get_db())
    user = db.query(User).filter_by(id=user_id).first()
    return user

@app.post("/users")
def create_user(user: UserDTO):
    db = next(get_db())
    db.add(user)
    db.commit()
    return user

@app.put("/users/{user_id}")
def update_user(user_id: int, user: UserDTO):
    db = next(get_db())
    db.query(User).filter_by(id=user_id).update(user)
    db.commit()
    return user

@app.delete("/users/{user_id}")
def delete_user(user_id: int):
    db = next(get_db())
    db.query(User).filter_by(id=user_id).delete()
    db.commit()
    return {"message": "User deleted successfully"}

@app.get("/registrations")
def get_registrations():
    db = next(get_db())
    registrations = db.query(Registration).all()
    return registrations

@app.get("/registrations/{registration_id}")
def get_registration(registration_id: int):
    db = next(get_db())
    registration = db.query(Registration).filter_by(id=registration_id).first()
    return registration

@app.post("/registrations")
def create_registration(registration: RegistrationDTO):
    db = next(get_db())
    db.add(registration)
    db.commit()
    return registration

@app.put("/registrations/{registration_id}")
def update_registration(registration_id: int, registration: RegistrationDTO):
    db = next(get_db())
    db.query(Registration).filter_by(id=registration_id).update(registration)
    db.commit()
    return registration

@app.delete("/registrations/{registration_id}")
def delete_registration(registration_id: int):
    db = next(get_db())
    db.query(Registration).filter_by(id=registration_id).delete()
    db.commit()
    return {"message": "Registration deleted successfully"}

@app.get("/eventadmins")
def get_eventadmins():
    db = next(get_db())
    eventadmins = db.query(EventAdmin).all()
    return eventadmins

@app.get("/eventadmins/{eventadmin_id}")
def get_eventadmin(eventadmin_id: int):
    db = next(get_db())
    eventadmin = db.query(EventAdmin).filter_by(id=eventadmin_id).first()
    return eventadmin

@app.post("/eventadmins")
def create_eventadmin(eventadmin: EventAdminDTO):
    db = next(get_db())
    db.add(eventadmin)
    db.commit()
    return eventadmin

@app.put("/eventadmins/{eventadmin_id}")
def update_eventadmin(eventadmin_id: int, eventadmin: EventAdminDTO):
    db = next(get_db())
    db.query(EventAdmin).filter_by(id=eventadmin_id).update(eventadmin)
    db.commit()
    return eventadmin

@app.delete("/eventadmins/{eventadmin_id}")
def delete_eventadmin(eventadmin_id: int):
    db = next(get_db())
    db.query(EventAdmin).filter_by(id=eventadmin_id).delete()
    db.commit()
    return {"message": "EventAdmin deleted successfully"}

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
