
package library.management.system;
import java.util.Date;
// Transaction class : This class manages the process of users borrowing and returning books
public class Transaction {
     private final User user; // User who is borrowing or returning the book
    private final Book book; // Book being borrowed or returned
    private final String action; // The action (borrow or return)
    private static Date transactionDate; // Date of the transaction

    // Constructor: Creates a new transaction with the user, book, action, and date
    public Transaction(User user, Book book, String action) {
        this.user = user; // Sets the user who borrowed or returned the book
        this.book = book; // Assigns the book that is being borrowed or returned 
        this.action = action; 
        Transaction.transactionDate = new Date(); // Sets the date and time when the transaction happens
    }

    // This class manages the process of users borrowing and returning books
    public void executeTransaction() {
        // Check if the action is "borrow"
        if (action.equals("borrow") || action.equals("BORROW")) {
            // If the action is borrow, try to borrow the book and show a message
            if (user.borrow(book)) { // Calls the borrow method in User class
                System.out.println("The book '" + book.getBookTitle() + "' was borrowed by " + user.getEmailAddress() + " on " + transactionDate + ".");
            }
        }
        // Check if the action is "return"
        else if (action.equals("return") || action.equals("RETURN")) {
            // If the action is return, return the book and show a message
            user.returnBorrowedBook(book); // Calls the return method in User class
            System.out.println("The book '" + book.getBookTitle() + "' was returned by " + user.getEmailAddress() + " on " + transactionDate + ".");
        }
        // If the action is neither "borrow" nor "return"
        else {
            // Show an error message for invalid input
            System.out.println("Invalid input. Try again.");
        }
    }
}
    

