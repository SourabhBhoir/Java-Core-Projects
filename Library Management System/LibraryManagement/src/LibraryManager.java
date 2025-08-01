import java.io.*;
import java.util.*;

public class LibraryManager {
    private List<Book> books;
    private final String fileName = "books.txt";

    public LibraryManager(){
        books = new ArrayList<>();
        loadBooksFromFile(); //LOad Books
    }

    //Load from file
    private void loadBooksFromFile(){
        File file = new File(fileName);
        if(!file.exists()) return;

        try( BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length == 3 ){
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String author = parts[2];
                    books.add(new Book(id, title, author));
               }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error reading file: " + e.getMessage());
        }
    }
       
    //Saved
    private void saveBooksToFile(){
        try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
            for(Book book: books){
                pw.println(book.toFileString());
            }
        } catch(IOException e){
            System.out.println("Error Saving File " + e.getMessage());
        }
    }
    //Search
      public void searchBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("🔍 Found: " + book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ Book not found.");
        }
    }

    //ADD
    public void addBook(Book book){
        books.add(book);
        saveBooksToFile();
        System.out.println("Book added succesfully!");
    }

    // Delete book by ID
    public void deleteBook(int id) {
        boolean removed = books.removeIf(book -> book.getId() == id);
        if (removed) {
            saveBooksToFile();
            System.out.println("🗑️ Book deleted.");
        } else {
            System.out.println("❌ Book ID not found.");
        }
    }
}

