from sqlalchemy import create_engine, Column, Integer, String, Date, DECIMAL, BLOB, ForeignKey
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import relationship

# Create the SQLite database engine
engine = create_engine('sqlite:///event_registration.db', echo=True)

Base = declarative_base()

# Define the classes representing the tables
class Event(Base):
    __tablename__ = 'events'

    event_id = Column(Integer, primary_key=True)
    event_name = Column(String(255), nullable=False)
    location = Column(String(255), nullable=False)
    event_date = Column(Date, nullable=False)
    capacity = Column(Integer, nullable=False)
    price = Column(DECIMAL(10, 2), nullable=False)
    image = Column(BLOB)

class User(Base):
    __tablename__ = 'users'

    user_id = Column(Integer, primary_key=True)
    username = Column(String(255), nullable=False)
    email = Column(String(255), nullable=False)
    password = Column(String(255), nullable=False)
    full_name = Column(String(255))
    phone_number = Column(String(20))
    address = Column(String(255))

class EventAdmin(Base):
    __tablename__ = 'event_admins'

    event_id = Column(Integer, ForeignKey('events.event_id'), primary_key=True)
    admin_id = Column(Integer, ForeignKey('users.user_id'), primary_key=True)
    event = relationship('Event')
    admin = relationship('User')

class Registration(Base):
    __tablename__ = 'registrations'

    registration_id = Column(Integer, primary_key=True)
    event_id = Column(Integer, ForeignKey('events.event_id'), nullable=False)
    user_id = Column(Integer, ForeignKey('users.user_id'), nullable=False)
    payment_status = Column(String(50), nullable=False)
    amount_paid = Column(DECIMAL(10, 2), nullable=False)
    event = relationship('Event')
    user = relationship('User')

# Create the tables in the database
Base.metadata.create_all(engine)



