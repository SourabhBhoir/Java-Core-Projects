public class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author= author;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    //save to file
    public String toFileString(){
        return id +"," + title + "," + author;
    }

    @Override
    public String toString(){
       return "ID: " + id + " | Title: " + title + " | Author: " + author;
    }
}
