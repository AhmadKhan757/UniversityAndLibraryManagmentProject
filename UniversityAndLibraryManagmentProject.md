# University Management System

A backend REST API project built with **Java and Spring Boot** for managing university and library-related operations. The project is designed to practice real-world backend development concepts including **REST APIs, DTOs, JPA/Hibernate relationships, PostgreSQL, exception handling, and service-layer business logic**.

##  Features

###  University Management

* Student management
* Department management
* Course management
* Teacher management
* Student address management
* Course enrollment
* Enrollment date tracking
* Validation and exception handling

###  Library Management

* Book management
* Author management
* Category management
* Student book borrowing
* Borrow record management
* Borrow and return date tracking

##  Entity Relationships

The project uses **JPA/Hibernate** to model relationships between entities.

Main relationships include:

* Student ↔ Address
* Student ↔ Department
* Student ↔ Enrollment
* Course ↔ Enrollment
* Student ↔ BorrowRecord
* Book ↔ BorrowRecord
* Book ↔ Author
* Book ↔ Category

The relationships use appropriate JPA mappings such as:

* `@OneToOne`
* `@OneToMany`
* `@ManyToOne`
* `@ManyToMany`

##  Tech Stack

| Technology      | Purpose                 |
| --------------- | ----------------------- |
| Java            | Programming Language    |
| Spring Boot     | Backend Framework       |
| Spring Data JPA | Database Access         |
| Hibernate       | ORM                     |
| PostgreSQL      | Database                |
| Maven           | Dependency Management   |
| REST API        | API Architecture        |
| Postman         | API Testing             |
| IntelliJ IDEA   | Development Environment |

##  Project Structure

```text
src/
└── main/
    ├── java/
    │   └── firstproject/
    │       └── RestApplication/
    │           ├── Controller/
    │           ├── Service/
    │           ├── Repository/
    │           ├── Entity/
    │           ├── DTO/
    │           ├── Mapper/
    │           └── Exception/
    │
    └── resources/
        └── application.properties

pom.xml
```

##  Database

The application uses **PostgreSQL** as its relational database.

Database configuration is kept outside the public repository where appropriate. Local configuration and environment files such as `.env` and `application-local.properties` are excluded using `.gitignore`.

##  Getting Started

### 1. Clone the repository

```bash
git clone <your-repository-url>
```

### 2. Open the project

Open the project in **IntelliJ IDEA** or another Java IDE.

### 3. Configure PostgreSQL

Create a PostgreSQL database and configure your local database credentials.

Keep sensitive credentials in your local configuration rather than committing them to GitHub.

### 4. Build the project

```bash
mvn clean install
```

### 5. Run the application

Run the Spring Boot application from IntelliJ or using:

```bash
mvn spring-boot:run
```

The REST API can then be tested using **Postman**.

##  API Testing

The APIs can be tested using Postman.

The project includes endpoints for managing:

* Students
* Courses
* Departments
* Teachers
* Addresses
* Books
* Authors
* Categories
* Enrollments
* Borrow Records

##  What I Practiced

This project helped me gain practical experience with:

* Building REST APIs with Spring Boot
* Layered architecture
* Controller-Service-Repository pattern
* DTOs and entity separation
* JPA/Hibernate
* Entity relationships
* Cascade types and fetch strategies
* PostgreSQL integration
* Exception handling
* Business logic implementation
* API testing with Postman
* Maven project management
* Git and GitHub

##  Future Improvements

Planned improvements include:

* JWT authentication
* Role-based authorization
* Pagination and sorting
* Advanced filtering and searching
* JPQL/custom queries
* Transaction management
* Better validation
* API documentation with Swagger/OpenAPI
* Improved security

##  Author

**Ahmad Khan**

This project is part of my journey toward becoming a **Java/Spring Boot Backend Developer**.
