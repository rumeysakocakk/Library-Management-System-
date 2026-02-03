
package library.management.system;

// User class : This class represents a library user who can borrow and return books.
public class User {
    private final String name; // User's name
    private final String email; // User's email
    private final Book[] borrowedBooks; // Array of borrowed books
    private int borrowedCount; // Number of books borrowed
    private static final int MAX_BORROWED_BOOKS = 3; // Max books a user can borrow at once

    // Constructor: Initializes a new User with name and email
    public User(String name, String email) {
        this.name = name; // Assigns the user's name to the name field
        this.email = email;  // Assigns the user's email to the email field
        this.borrowedBooks = new Book[MAX_BORROWED_BOOKS]; // Creates a fixed size array for borrowed books
        this.borrowedCount = 0; // Initially the user has not borrowed any books
    }

    // Returns the user's email
    public String getEmailAddress() { 
        return email; 
    }

    // Allows borrowing a book if not exceeding the limit and the book is available
    public boolean borrow(Book book) {
         // Check if the user hasn't reached the maximum borrowing limit and the book is available
        if (borrowedCount < MAX_BORROWED_BOOKS && book.getBooksAvailable() > 0) {
            borrowedBooks[borrowedCount++] = book; // Add book to borrowed list
            book.borrowBookFromLibrary(); // Decrease available copies
            return true;  // Successfully borrowed the book
        } else {
            // The user has either reached the borrowing limit or the book is not in stock.
            System.out.println("Cannot borrow more books. Limit reached or book unavailable.");
            return false;
        }
    }

    // Allows returning a borrowed book and updating the available copies
    public void returnBorrowedBook(Book book) {
        // Loop through borrowed books to find the book to return
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i] == book) { // Check if the current book in the array matches the book to be returned 
                borrowedBooks[i] = borrowedBooks[--borrowedCount]; // Replace the returned book with the last book in the array
                borrowedBooks[borrowedCount] = null; // Clear the last position in the array
                book.returnBookToLibrary(); // Return the book and increase available copies
                break;
            }
        }
    }
}
    

