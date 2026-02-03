
package library.management.system;

// Book class : This class models a book and stores details such as the title, author, available copies, and total copies.
public class Book {
    private final String title; // Name of the book
    private final String author; // Writer of the book
    private int availableCopies; // The quantity of copies available for lending
    private final int totalCopies; // The overall number of copies of the book in the library
    private static int totalBooks = 0; // Static variable to count all books created

    // Constructor to create a new book object with the title, author, and total copies.
    public Book(String title, String author, int totalCopies) {
        this.title = title; // Set the title field with the provided title.
        this.author = author; // Set the provided author to the author field.
        this.totalCopies = totalCopies; // Sets the total number of copies available
        this.availableCopies = totalCopies; // Initially, all copies are available for borrowing
        totalBooks++; // Increases the total number of books created each time a new book is added
    }
    // Returns the title of the book
    public String getBookTitle() {
        return title;
    }
     // Returns the name of the author of the book
    public String getAuthorName() {
        return author;
    }
    // Returns the number of available copies of the book
    public int getBooksAvailable() {
        return availableCopies;
    }
    // Allows a user to borrow a book from the library, decreasing the number of available copies
    public void borrowBookFromLibrary() {
        if (availableCopies > 0) {
            availableCopies--;
        }
    }
    // Allows a user to return a book to the library, increasing the number of available copies
    public void returnBookToLibrary() {
        // Checks if there are copies that can be returned
        if (availableCopies < totalCopies) {
            availableCopies++;  // Increases the available copies count by one
        }
    }
    // Static method to return the total count of books that have been created
    public static int getTotalBooksCreated() {
        return totalBooks; // Returns the total number of books created
    }
    // Returns a detailed string of the book's information, including title, author, and available copies
    public String getBookDetails() {
        // Returns a string formatted with the title, author, and the number of available copies
        return title + " written by " + author + ", with " + availableCopies + " copies available.";
}
    }
    

