# Library Management System

## Overview

Library Management System is a console-based Java application developed to apply object-oriented programming principles and fundamental data structure concepts.

The system manages books, users, and borrowing operations while enforcing predefined library rules. Books are organized through a two-dimensional array structure that represents physical library shelves.

## Features

- Book inventory management
- User registration and management
- Book borrowing and returning
- Availability and stock tracking
- Transaction recording with timestamps
- Maximum borrowing limit of three books per user
- Input validation and invalid-operation handling
- Two-dimensional shelf organization

## Technologies and Concepts

- Java
- Object-Oriented Programming
- Encapsulation
- Composition
- Static class members
- Two-dimensional arrays
- Console-based user interaction
- Java Standard Library

## Object-Oriented Design

The application separates its responsibilities across multiple classes:

- Encapsulation is used to protect object data through private fields and controlled access methods.
- Composition allows the `Library` class to coordinate books, users, and transactions.
- Static members are used where information must be shared across all instances.
- Each class represents a distinct part of the library domain.

## Business Rules

The application applies the following rules during borrowing and returning operations:

- A user can borrow a maximum of three books.
- A book must be available before it can be borrowed.
- Book availability is updated after borrowing and returning.
- Invalid borrowing and returning attempts are handled safely.
- Transactions are recorded with their corresponding timestamps.

## Project Structure

| File | Responsibility |
|------|----------------|
| `Book.java` | Stores book information and tracks total and available copies. |
| `User.java` | Stores user details and borrowing information. |
| `Library.java` | Manages books, shelves, registered users, and core system operations. |
| `Transaction.java` | Represents borrowing and returning transactions. |
| `Main.java` | Provides the console-based user interface and application entry point. |

## Getting Started

### Prerequisites

To run the project, Java Development Kit (JDK) must be installed.

You can verify the installation with:

```bash
java -version
javac -version
```

### Running the Project

1. Clone the repository:

```bash
git clone https://github.com/rumeysakocakk/Library-Management-System-.git
```

2. Navigate to the project directory:

```bash
cd Library-Management-System-
```

3. Open the project in NetBeans and run `Main.java`.

Alternatively, compile and run the project from the command line according to its package structure.

## Learning Outcomes

This project was developed during my first year of Software Engineering education. It provided practical experience in:

- Designing classes with separate responsibilities
- Applying object-oriented programming principles
- Managing data using arrays
- Implementing business rules and validations
- Organizing a Java console application
- Modeling a real-world system through software

## Future Improvements

Possible improvements include:

- Replacing arrays with Java Collections
- Adding persistent data storage
- Integrating a relational database with JDBC
- Developing a graphical user interface
- Implementing role-based access for librarians and users
- Adding advanced book search and filtering
- Writing unit tests for core operations

## Author

**Rumeysa Elif Koçak**  
Software Engineering Student

GitHub: [rumeysakocakk](https://github.com/rumeysakocakk)
