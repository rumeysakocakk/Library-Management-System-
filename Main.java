
package library.management.system;

import java.util.Scanner;


public class Main {

    
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in); // Create a scanner to get input from the user
        Library library = new Library(); // Create a new Library object

        while (true) { // Keep the program running until the user chooses to stop
            // Show the menu options for the user to choose from
            System.out.println("Library Management System:");
            System.out.println("1. Add a New Book");
            System.out.println("2. Register a New User");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Display all Books");
            System.out.println("6. View Transactions");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt(); // Get the user's choice
            scanner.nextLine(); // Remove extra new line character

            if (choice == 1) {
                // Option 1: Add a New Book
                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine(); // Get the book's title
                System.out.print("Enter Author: ");
                String author = scanner.nextLine(); // Get the author's name
                System.out.print("Enter Total Copies: ");
                int totalCopies = scanner.nextInt(); // Get the number of copies of the book
                scanner.nextLine(); // Remove extra new line character
                library.addBook(new Book(title, author, totalCopies)); // Add the book to the library
            } 
            else if (choice == 2) {
                // Option 2: Register a New User
                System.out.print("Enter User Name: ");
                String name = scanner.nextLine(); // Get the user's name
                System.out.print("Enter User Email: ");
                String email = scanner.nextLine(); // Get the user's email
                library.registerUser(new User(name, email)); // Register the user in the library
            } 
            else if (choice == 3) {
                // Option 3: Borrow a Book
                System.out.print("Enter User Email: ");
                String email = scanner.nextLine(); // Get the user's email
                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine(); // Get the book's title
                System.out.print("Enter Book Author: ");
                String author = scanner.nextLine(); // Get the author's name
                library.borrowBook(email, title, author); // Borrow the book
            } 
            else if (choice == 4) {
                // Option 4: Return a Book
                System.out.print("Enter User Email: ");
                String email = scanner.nextLine(); // Get the user's email
                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine(); // Get the book's title
                System.out.print("Enter Book Author: ");
                String author = scanner.nextLine(); // Get the author's name
                library.returnBook(email, title, author); // Return the book
            } 
            else if (choice == 5) {
                // Option 5: Display all Books
                library.displayAllBooks(); // Show all books in the library
            } 
            else if (choice == 6) {
                // Option 6: View all Transactions
                library.displayAllTransactions(); // Show all the borrow and return actions
            } 
            else if (choice == 7) {
                // Option 7: Exit the system
                System.out.println("Program exited successfully."); // Tell the user the program is ending
                break; // Stop the loop and exit the program
            } 
            else {
                // If the user enters an invalid option
                System.out.println("Invalid choice. Please try again."); // Inform the user of the wrong choice
            }
        }
    }
} 
    
    

