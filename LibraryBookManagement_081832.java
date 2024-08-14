import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Book {
    String title;
    String author;
    String ISBN;
    boolean isAvailable;
    ArrayList<String> lendingHistory;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
        this.lendingHistory = new ArrayList<>();
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Checked out"));
        if (!lendingHistory.isEmpty()) {
            System.out.println("Lending History: " + lendingHistory);
        }
    }

    public void checkOut(String borrower) {
        if (isAvailable) {
            isAvailable = false;
            lendingHistory.add("Borrowed by " + borrower);
            System.out.println("Book checked out successfully by " + borrower);
        } else {
            System.out.println("Book is not available");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            lendingHistory.add("Returned");
            System.out.println("Book returned successfully");
        } else {
            System.out.println("Book was not checked out");
        }
    }
}

class Library {
    HashMap<String, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.ISBN, book);
        System.out.println("Book added: " + book.title);
    }

    public Book searchBook(String ISBN) {
        return books.get(ISBN);
    }
}

public class LibraryBookManagement {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "1234567891"));

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Check Out Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Book Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    library.addBook(new Book(title, author, ISBN));
                    break;
                case 2:
                    System.out.print("Enter ISBN to search: ");
                    ISBN = scanner.nextLine();
                    Book book = library.searchBook(ISBN);
                    if (book != null) {
                        book.displayDetails();
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 3:
                    System.out.print("Enter ISBN to check out: ");
                    ISBN = scanner.nextLine();
                    System.out.print("Enter borrower's name: ");
                    String borrower = scanner.nextLine();
                    book = library.searchBook(ISBN);
                    if (book != null) {
                        book.checkOut(borrower);
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 4:
                    System.out.print("Enter ISBN to return: ");
                    ISBN = scanner.nextLine();
                    book = library.searchBook(ISBN);
                    if (book != null) {
                        book.returnBook();
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 5:
                    System.out.print("Enter ISBN to display details: ");
                    ISBN = scanner.nextLine();
                    book = library.searchBook(ISBN);
                    if (book != null) {
                        book.displayDetails();
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}