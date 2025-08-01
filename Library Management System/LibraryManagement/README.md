📚 Library Management System (Console-Based)
A simple Java console application to manage a collection of books. This system allows users to add, view, search, and delete books. Book data is stored persistently in a local text file (books.txt).

✨ Features
➕ Add a new book (ID, title, author)

📃 View all books

🔍 Search for a book by title

🗑️ Delete a book by ID

💾 File-based storage using books.txt

🛠️ Technologies Used
Java SE (Core)

Java I/O (BufferedReader, FileWriter, PrintWriter)

Console input via Scanner

📁 Project Structure
bash
Copy code
.
├── Book.java             # Represents a book with id, title, and author
├── LibraryManager.java   # Handles all library operations and file I/O
├── Main.java             # User interface (console menu and interaction)
├── books.txt             # Text file used for storing books (auto-created)
└── README.md             # Project documentation
🚀 How to Run
✅ Requirements
Java 8 or above

🧪 Steps
Compile the code:

bash
Copy code
javac Main.java LibraryManager.java Book.java
Run the application:

bash
Copy code
java Main
Use the menu:

markdown
Copy code
📚 Library Management Menu:
1. Add Book
2. View All Books
3. Search Book by Title
4. Delete Book by ID
5. Exit
💡 Example Usage
Adding a book:

yaml
Copy code
Enter Book ID: 1
Enter Title: Java Basics
Enter Author: John Doe
Book added successfully!
Searching for a book:

yaml
Copy code
Enter title to search: Java Basics
🔍 Found: ID: 1 | Title: Java Basics | Author: John Doe
books.txt Format:

Copy code
1,Java Basics,John Doe
2,Effective Java,Joshua Bloch
📌 Notes
The file books.txt is created automatically if it doesn't exist.

Each book entry is stored as a single line: ID,Title,Author

File is updated every time a book is added or deleted.

📄 License
This project is provided for educational purposes and is open to modifications and improvements.

👨‍💻 Author
[Sourabh Bhoir]
Feel free to fork, improve, or contribute!

