# 📚 Library Management System (Java)

## 🚀 Project Overview
This project was developed during my **1st Year – 1st Semester** to strengthen my understanding of **Object-Oriented Programming (OOP)** and **basic data structures** in Java.

It is a **console-based Library Management System** that manages books, users, and borrowing/returning transactions using clear business rules and validations.

---

## 🎯 Project Objectives
- Learn and apply **Object-Oriented Programming principles**
- Practice **data handling using arrays**
- Build a **structured and maintainable Java application**
- Simulate a **real-world library system**

---

## 🛠️ Technologies Used
- **Java**
- **Object-Oriented Programming (OOP)**
- **2D Arrays**
- **Console-Based Application**
- **Java Standard Library**

---

## ✨ Technical Highlights

### 🔹 Object-Oriented Design
- **Encapsulation:**  
  Private fields with public getters and setters are used to protect data integrity.
  
- **Composition:**  
  The `Library` class acts as a central controller managing books, users, and transactions.
  
- **Static Members:**  
  Static variables and methods are used to track system-wide data.

---

### 🔹 Data Structures
- **2D Array Inventory System:**  
  Books are stored using a `Book[][] shelves` structure to simulate physical library shelves.

- **Dynamic Capacity Expansion:**  
  When shelves are full, the system expands storage capacity logically.

---

### 🔹 Business Logic & Validation
- **Transaction Management:**  
  Borrowing and returning actions are recorded with timestamps.
  
- **Borrowing Rules:**
  - Maximum **3 books per user**
  - Availability check before borrowing
  - Safe handling of invalid operations

---

## 📂 Class Structure

### 📘 Book.java
Models book information and tracks total and available copies.

### 👤 User.java
Stores user details and borrowing history.

### 🏛️ Library.java
The core logic of the system, including shelf management and user registration.

### 🔁 Transaction.java
Handles borrowing and returning operations with timestamps.

### ▶️ Main.java
Provides a command-line interface (CLI) for user interaction.

---

## 🚀 How to Run

### 1️⃣ Compile the source files
```bash
javac library/management/system/*.java

