package Task;

public class Task11 {
class Book {
    String title;
    String author;
    int yearPublished;
    double price;

    // Constructor
    public Book(String title, String author, int yearPublished, double price) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    // toString() method
    @Override
    public String toString() {
        return "Title: " + title +
               ", Author: " + author +
               ", Year Published: " + yearPublished +
               ", Price: $" + price;
    }
}

public class Main {
    public static void main(String[] args) {

        // Create three Book objects
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 10.99);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960, 12.50);
        Book book3 = new Book("1984", "George Orwell", 1949, 9.99);

        // Print book details using toString()
        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());
    }
}
}
