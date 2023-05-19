# MainTicket Service

The MainTicket Service is a lightweight backend that enables event check-in functionality. Built using Python, SQLite, and FastAPI.

## Features

- Register events with details such as location, dates, capacity, and pricing.
- Allow users to create an account, register for events, and update their payment status.
- Administrators can update the payment status of users.

## Prerequisites

Before running the backend service, ensure you have the following installed:

- Python (version X.X.X)
- SQLite (version X.X.X)

## Installation

1. Clone this repository to your local machine.
2. Navigate to the project directory.
3. Install the required dependencies by running the following command:

```bash
pip install -r requirements.txt
```


## Configuration

Before running the backend, you may need to configure some settings.

1. Open the `config.py` file in a text editor.
2. Modify the configuration parameters as needed, including database settings and server configuration.

## Usage

1. Ensure your SQLite database is set up and accessible. You can create a new database file or use an existing one.
2. Run the following command to start the backend service:

```bash
uvicorn main:app --reload
```


3. Once the server is running, you can access the API endpoints using a REST client or web browser.

## API Endpoints

The Check-In Service exposes the following API endpoints:

- `/events`:
- `GET /events` - Retrieve a list of all events.
- `POST /events` - Register a new event.
- `GET /events/{event_id}` - Retrieve details of a specific event.
- `/users`:
- `POST /users` - Create a new user account.
- `GET /users/{user_id}` - Retrieve details of a specific user.
- `/registrations`:
- `POST /registrations` - Register a user for an event.
- `GET /registrations/{registration_id}` - Retrieve details of a specific registration.
- `PATCH /registrations/{registration_id}` - Update the payment status of a registration.

Please refer to the API documentation for detailed information on the request and response formats.

## Contributing

Contributions are welcome! If you find any issues or would like to enhance the functionality, please submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

For any questions or inquiries, please contact [Kevin Madrid](mailto:kmadridr@gmail.com).

Feel free to update and customize this README file based on your specific requirements and project details.
