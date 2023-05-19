from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker

from models import Base

# Configure the database connection
SQLALCHEMY_DATABASE_URL = 'sqlite:///event_registration.db'

# Create the database engine
engine = create_engine(SQLALCHEMY_DATABASE_URL, echo=True)

# Create a session factory
SessionLocal = sessionmaker(bind=engine)

# Function to get a new database session
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

# Function to create the database tables
def create_tables():
    Base.metadata.create_all(bind=engine)
