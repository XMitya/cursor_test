# Spring Boot Demo Application

A Spring Boot REST API application with PostgreSQL database, Liquibase migrations, and Spring Security.

## Technologies

- Java 23
- Spring Boot 3.4.1
- Gradle 8.6
- PostgreSQL 16
- Liquibase
- Spring Security
- SpringDoc OpenAPI (Swagger)
- Lombok

## Prerequisites

- JDK 23
- Docker and Docker Compose
- Gradle (optional, wrapper included)

## Getting Started

1. Start PostgreSQL:
```bash
docker compose up -d
```

2. Run the application:
```bash
gradle bootRun
```


The application will be available at `http://localhost:8080`

## API Documentation

Swagger UI: `http://localhost:8080/swagger-ui.html`

## Endpoints

### Users API
- GET `/api/users` - Get all users
- GET `/api/users/{id}` - Get user by ID
- POST `/api/users` - Create new user
- PUT `/api/users/{id}` - Update user
- DELETE `/api/users/{id}` - Delete user

### Hello API
- GET `/app/hello` - Returns "Hello world"

## Database Configuration

PostgreSQL database settings:
- URL: jdbc:postgresql://localhost:5432/hello_db
- Username: postgres
- Password: postgres

## Database Migrations

Liquibase migrations are located in:
```
src/main/resources/db/changelog/
├── db.changelog-master.yaml
└── changes/
└── 001-create-users-table.yaml
```

To run migrations manually:
```bash
gradle liquibaseUpdate
```

## Security

Spring Security is configured to permit all requests. Passwords are hashed using BCrypt.

## Project Structure
```
src/
├── main/
├── java/
│ └── com/example/demo/
│ ├── config/
│ │ ├── OpenApiConfig.java
│ │ └── SecurityConfig.java
│ ├── controller/
│ │ ├── HelloController.java
│ │ └── UserController.java
│ ├── dto/
│ │ ├── CreateUserRequest.java
│ │ └── UserDto.java
│ ├── entity/
│ │ └── User.java
│ ├── repository/
│ │ └── UserRepository.java
│ ├── service/
│ │ └── UserService.java
│ └── DemoApplication.java
└── resources/
├── application.properties
└── db/changelog/
├── db.changelog-master.yaml
└── changes/
└── 001-create-users-table.yaml
```

## Building
```bash
gradle build
```

## Running Tests
```bash
gradle test
```