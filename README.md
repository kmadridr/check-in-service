# check-in-service
This project is the logic/business tier of a three tier architecture. The whole system is a check-in application to register for an specific event.

Docker commands to build image and run container:
- `docker build -t mdpdn/check-in-service .`
- `docker run -p 8080:8080 mdpdn/check-in-service`
