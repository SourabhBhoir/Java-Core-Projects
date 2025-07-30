StudentManager
StudentManager is a simple Java console application that performs basic CRUD operations (Create, Read, Update, Delete) on a MySQL database containing student records.

📋 Features
Add new student records

View all student records

Update existing student information

Delete a student record by ID

Menu-driven interface via command line

🛠️ Technologies Used
Java (JDK 8 or higher)

JDBC (Java Database Connectivity)

MySQL Database

🧱 Database Schema
Make sure your MySQL database has a table called students with the following structure:

sql
Copy code
CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    course VARCHAR(100) NOT NULL
);
⚙️ Setup Instructions
Clone or download the project
Place the Java file StudentManager.java in your project directory.

Configure database connection
Open StudentManager.java and update the following constants to match your MySQL setup:

java
Copy code
static final String URL = "jdbc:mysql://localhost:3306/studentdb";
static final String USER = "root";         // Your MySQL username
static final String PASSWORD = "password"; // Your MySQL password
Compile the Java code
Ensure you have the MySQL JDBC driver (mysql-connector-java-x.x.x.jar) in your classpath.

bash
Copy code
javac -cp .:mysql-connector-java-8.0.33.jar StudentManager.java
Run the application

bash
Copy code
java -cp .:mysql-connector-java-8.0.33.jar StudentManager