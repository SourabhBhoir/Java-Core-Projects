 Simple Banking System in Java (with MySQL & JDBC Integration)
InBank is a simple command-line banking application built in Java that allows users to create accounts, log in, deposit, withdraw, and check balances. It is designed for beginners to learn core Java programming concepts, OOP, and JDBC (Java Database Connectivity) for storing account data in a MySQL database.

✅ Note: The current code stores data in-memory using ArrayList. To persist data in MySQL, JDBC integration needs to be implemented (see Planned Enhancements).

📂 Project Structure
bash
Copy code
InBank/
├── src/
│   ├── Account.java         # Represents a user's bank account
│   └── BankManagement.java  # Main logic and user interaction
├── README.md
└── (future) db/             # SQL scripts or DB connection files
🛠 Features
Create a new account (with unique username)

Secure password validation

Deposit and withdraw funds

Check current account balance

Basic menu-driven CLI interface

🔧 Requirements
Java 8 or above

(Optional) MySQL Server

(Planned) JDBC driver for MySQL

▶️ How to Run
Compile the Java files:

bash
Copy code
javac Account.java BankManagement.java
Run the main class:

bash
Copy code
java BankManagement
💾 Planned Enhancements: JDBC & MySQL Integration
To store user data persistently in a MySQL database, the following additions are planned:

Create a MySQL Database

sql
Copy code
CREATE DATABASE inbank;

USE inbank;

CREATE TABLE accounts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    balance DOUBLE DEFAULT 0.0
);
Add JDBC Connectivity

Update Account and BankManagement to include:

JDBC connection setup

Insert account to DB during account creation

Fetch & validate user during login

Update balance after deposit/withdraw

Add DBUtil.java to manage DB connection and query logic.

📚 Concepts Demonstrated
Java Classes and Objects

Encapsulation

ArrayList & Control Flow

Exception Handling

CLI-based interaction

JDBC (planned)

✍️ Author
Sourabh Bhoir