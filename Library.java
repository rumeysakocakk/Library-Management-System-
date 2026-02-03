
package library.management.system;

// Library class : Controls books, users, and actions in the library
public class Library {
   
    private Book[][] shelves; // Shelves where books are stored (2D array of books)
    private User[] users; // List of registered users
    private Transaction[] transactions; // List of transaction records
    private int userCount; // Total number of registered users
    private int transactionCount; // Total number of transactions
    private static final int INITIAL_SHELF_COUNT = 10; // Starting with 10 shelves
    private static final int SHELF_CAPACITY = 4; // Maximum 4 books per shelf

    // Constructor: Sets up the library with empty shelves, users, and transactions
    public Library() {
        shelves = new Book[INITIAL_SHELF_COUNT][SHELF_CAPACITY]; // Start the shelves with 10 shelves that hold 4 books each
        users = new User[100]; // Initially allows space for 100 users
        transactions = new Transaction[1000]; // Initially allows space for 1000 transactions
        userCount = 0; // No users at first.
        transactionCount = 0; // There are no transactions at first.
    }

    // Adds a book to the library. If there's no space, a new shelf is created
    public void addBook(Book book) {
        // Check the shelves for available space for the book.
        for (int i = 0; i < shelves.length; i++) {
            for (int j = 0; j < SHELF_CAPACITY; j++) {
                // Check if the current shelf position is empty (null).
                if (shelves[i][j] == null) {
                    shelves[i][j] = book; // If the spot is empty, place the book there.
                    System.out.println("Book '" + book.getBookTitle() + "' by " + book.getAuthorName() + " has been added.");
                    // Display a message confirming the book has been successfully added to the shelf.
                    return;
                }
            }
        }
        // If no space in the shelves, so a new shelf is added
        createNewShelf(); // Add one more shelf to the library
        shelves[shelves.length - 1][0] = book; // Put the book at the beginning of the new shelf
        System.out.println("New shelf added. Book '" + book.getBookTitle() + "' placed.");
    }

    // Creates a new shelf for the library
    private void createNewShelf() {
        // Create a new shelf that has one more shelf than the current total.
        Book[][] newShelves = new Book[shelves.length + 1][SHELF_CAPACITY]; // Add one more shelf
        // Copy books from old shelves to the new shelves
        for (int i = 0; i < shelves.length; i++) {
            for (int j = 0; j < SHELF_CAPACITY; j++) {
                newShelves[i][j] = shelves[i][j]; // Copy each book to the new shelf
            }
        }
        shelves = newShelves; // Replace the old shelves with the new shelves.
    }

    // Registers a new user if their email hasn't been taken
    public void registerUser(User user) {
    // Compare email addresses to check if the user is already registered.
        for (int i = 0; i < userCount; i++) {
            // Check if the email of the current user is not null and matches the new user's email
            if (users[i].getEmailAddress() != null && users[i].getEmailAddress().compareTo(user.getEmailAddress()) == 0) {
                System.out.println("User with email '" + user.getEmailAddress() + "' is already registered.");
                return; // Exit the method if the user is already registered
            }
        }
        users[userCount++] = user; // Add the user to the list and update the count
        System.out.println("User '" + user.getEmailAddress() + "' has been registered.");
    }

    // Finds a book by its title and author
    private Book findBook(String title, String author) {
         // Loop through all shelves
        for (int i = 0; i < shelves.length; i++) {
            // Check every spot on the current shelf
            for (int j = 0; j < SHELF_CAPACITY; j++) {
                Book book = shelves[i][j]; // Get the book at the current spot
                // Check if the book matches the given title and author
                if (book != null && book.getBookTitle().equals(title) && book.getAuthorName().equals(author)) {
                    return book; // Return the book if found
                }
            }
        }
        return null; // Return null if the book is not found (null means no book in that spot)
    }

    // Lets a user borrow a book
    public void borrowBook(String email, String title, String author) {
        User user = findUser(email); // Find the user by their email
        if (user == null) { // If the user is not found (user is null)
            System.out.println("User not found.");
            return;
        }
        // Find the book by its title and author
        Book book = findBook(title, author);
        if (book == null) { // If the book is not found (book is null)
            System.out.println("The requested book could not be found.");
            return;
        }
        // Allow the user to take the book if it's found
        if (user.borrow(book)) {
            // Record the borrow action by creating a new transaction and adding it to the transactions array.
            transactions[transactionCount++] = new Transaction(user, book, "borrow");
            System.out.println("Book '" + title + "' has been borrowed by " + email + ".");
        }
    }

    // Lets a user return a borrowed book
    public void returnBook(String email, String title, String author) {
        User user = findUser(email); // Find the user by their email
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        Book book = findBook(title, author); // Find the book by its title and author
        if (book == null) {
            System.out.println("The requested book could not be found.");
            return;
        }
        // Allow the user to return the book and add a transaction
        user.returnBorrowedBook(book);
        // Record the borrow transaction by creating a new Transaction object
        transactions[transactionCount++] = new Transaction(user, book, "return");
        System.out.println("Book '" + title + "' has been returned by " + email + ".");
    }

    // Finds a user by their email
    private User findUser(String email) {
        // Loop through all users to find the one with the matching email
        for (int i = 0; i < userCount; i++) {
            // Check if the current user's email matches the provided email
            if (users[i].getEmailAddress().equals(email)) {
                return users[i]; // Return the user if a match is found
            }
        }
        return null; // Return null if the user is not found
    }

    // Shows all the books available in the library
    public void displayAllBooks() {
        System.out.println("Books in the Library:");
        // Loop through all the shelves in the library
        for (int i = 0; i < shelves.length; i++) {
            // Loop through each spot on the current shelf
            for (int j = 0; j < SHELF_CAPACITY; j++) {
                Book book = shelves[i][j]; // Get the book from the current shelf spot (row i, column j)
                if (book != null) { // Check if the spot contains a book
                    System.out.println(book.getBookDetails());
                }
            }
        }
    }

    // Displays all transactions (borrow and return actions)
    public void displayAllTransactions() {
        System.out.println("All library transactions:");
        // Loop through all recorded transactions
        for (int i = 0; i < transactionCount; i++) {
            transactions[i].executeTransaction(); // Execute and display the details of the current transaction
        }
    }
}