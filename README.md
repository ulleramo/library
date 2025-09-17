# 📚 Library Management System

A simple **Spring Boot + HSQLDB** application that simulates a small library system.  
You can manage books, members, and loans — all against an **in-memory HyperSQL database**.

This project demonstrates clean **Controller → Service → Repository** layering, use of `schema.sql` and `data.sql` for database initialization, and API documentation with Swagger UI.

---

## 📌 Table of Contents
- [Description](#description)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
    - [Clone the repository](#clone-the-repository)
    - [Build & Run](#build--run)
    - [Swagger UI](#swagger-ui)
- [Configuration](#configuration)
- [Database Initialization](#database-initialization)
- [Database Structure](#database-structure)
- [Available Endpoints](#available-endpoints)
- [Project Structure](#project-structure)
- [Git Cheat Sheet](#git-cheat-sheet)

---

## 📖 Description
This project implements **basic CRUD operations** for a library:

### MVP Features
- Manage **Books** (title, author, ISBN, published year)
- Manage **Members** (name, email, membership date)
- Manage **Loans** (which member borrowed which book, with loan/return dates)

---

## 🛠 Prerequisites
- Java 21
- Gradle (or use the included `gradlew`)
- IntelliJ IDEA (recommended)

---

## 🚀 Getting Started

### Clone the repository
```bash
git clone https://github.com/ulleramo/library.git
cd library
Build & Run
In IntelliJ IDEA:

Open the project (File ▸ Open...)

Let Gradle import automatically

Run LibraryApplication.java

On the command line:

bash
Kopeeri kood
./gradlew bootRun
Verify startup
Application runs at: http://localhost:8080

Swagger UI: http://localhost:8080/swagger-ui/index.html

⚙️ Configuration
Main configuration is in src/main/resources/application.properties.

By default, the app runs with an in-memory HSQLDB database that resets on every restart.

🗄 Database Initialization
schema.sql → creates tables (book, member, loan) with constraints and indexes.

data.sql → inserts initial sample data.

Spring Boot executes schema.sql and then data.sql automatically at startup.

🗂 Database Structure
ERD Diagram (Mermaid)

mermaid
Kopeeri kood
erDiagram
    BOOK {
        BIGINT id PK
        VARCHAR title
        VARCHAR author
        VARCHAR isbn UNIQUE
        INT published_year
    }

    MEMBER {
        BIGINT id PK
        VARCHAR name
        VARCHAR email UNIQUE
        DATE membership_date
    }

    LOAN {
        BIGINT id PK
        BIGINT book_id FK
        BIGINT member_id FK
        DATE loan_date
        DATE return_date
    }

    BOOK ||--o{ LOAN : "is borrowed in"
    MEMBER ||--o{ LOAN : "borrows"
🌐 Available Endpoints
Books
Method	Path	Description
GET	/books	List all books
GET	/books/{id}	Get book by ID
POST	/books	Add a new book
PUT	/books/{id}	Update a book
DELETE	/books/{id}	Delete a book

Members
Method	Path	Description
GET	/members	List all members
GET	/members/{id}	Get member by ID
POST	/members	Add a new member
PUT	/members/{id}	Update a member
DELETE	/members/{id}	Delete a member

Loans
Method	Path	Description
GET	/loans	List all loans
POST	/loans	Register a new loan
PUT	/loans/{id}	Update a loan (e.g. extend)
POST	/loans/{id}/return	Mark a loan as returned
DELETE	/loans/{id}	Delete a loan

📂 Project Structure
graphql
Kopeeri kood
library/
├── src/main/java/com/example/library/
│   ├── controller/        # REST controllers
│   ├── dto/               # DTOs
│   ├── entity/            # Entities (Book, Member, Loan)
│   ├── repository/        # Spring Data JPA repositories
│   ├── service/           # Business logic services
│   └── LibraryApplication.java
├── src/main/resources/
│   ├── application.properties
│   ├── schema.sql         # DDL for HSQLDB schema
│   └── data.sql           # Sample seed data
├── build.gradle
├── settings.gradle
├── README.md
└── .gitignore
