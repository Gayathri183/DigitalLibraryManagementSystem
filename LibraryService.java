import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryService {
    private List<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addBook() {
        System.out.println("\n--- Add a New Book ---");

        String id;
        while (true) {
            System.out.print("Enter Book ID: ");
            id = scanner.nextLine();
            if (isBookIdExists(id)) {
                System.out.println("Book ID already exists. Please enter a unique ID.");
            } else {
                break;
            }
        }

        String title;
        while (true) {
            System.out.print("Enter Title: ");
            title = scanner.nextLine();
            if (!title.isEmpty()) {
                break;
            }
            System.out.println("Title cannot be empty. Please try again.");
        }

        String author;
        while (true) {
            System.out.print("Enter Author: ");
            author = scanner.nextLine();
            if (!author.isEmpty()) {
                break;
            }
            System.out.println("Author cannot be empty. Please try again.");
        }

        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();

        Book newBook = new Book(id, title, author, genre);
        books.add(newBook);
        System.out.println("Book added successfully!");
    }

    public void viewAllBooks() {
        System.out.println("\n--- All Books in Library ---");
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBook() {
        System.out.println("\n--- Search for a Book ---");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Title");
        System.out.print("Enter your choice: ");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                searchById();
                break;
            case 2:
                searchByTitle();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void searchById() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                System.out.println("Book found:");
                System.out.println(book);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No book found with ID: " + id);
        }
    }

    private void searchByTitle() {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        boolean found = false;
        System.out.println("Search results:");
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found with title containing: " + title);
        }
    }

    public void updateBook() {
        System.out.println("\n--- Update Book Details ---");
        System.out.print("Enter Book ID to update: ");
        String id = scanner.nextLine();

        Book bookToUpdate = null;
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                bookToUpdate = book;
                break;
            }
        }

        if (bookToUpdate == null) {
            System.out.println("Book not found with ID: " + id);
            return;
        }

        System.out.println("Current details:");
        System.out.println(bookToUpdate);

        System.out.println("\nWhat would you like to update?");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. Genre");
        System.out.println("4. Availability Status");
        System.out.print("Enter your choice: ");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                updateTitle(bookToUpdate);
                break;
            case 2:
                updateAuthor(bookToUpdate);
                break;
            case 3:
                updateGenre(bookToUpdate);
                break;
            case 4:
                updateAvailability(bookToUpdate);
                break;
            default:
                System.out.println("Invalid choice. No updates made.");
        }
    }

    private void updateTitle(Book book) {
        String title;
        while (true) {
            System.out.print("Enter new Title: ");
            title = scanner.nextLine();
            if (!title.isEmpty()) {
                break;
            }
            System.out.println("Title cannot be empty. Please try again.");
        }
        book.setTitle(title);
        System.out.println("Title updated successfully!");
    }

    private void updateAuthor(Book book) {
        String author;
        while (true) {
            System.out.print("Enter new Author: ");
            author = scanner.nextLine();
            if (!author.isEmpty()) {
                break;
            }
            System.out.println("Author cannot be empty. Please try again.");
        }
        book.setAuthor(author);
        System.out.println("Author updated successfully!");
    }

    private void updateGenre(Book book) {
        System.out.print("Enter new Genre: ");
        String genre = scanner.nextLine();
        book.setGenre(genre);
        System.out.println("Genre updated successfully!");
    }

    private void updateAvailability(Book book) {
        System.out.println("Current status: " + book.getAvailabilityStatus());
        System.out.println("1. Available");
        System.out.println("2. Checked Out");
        System.out.print("Enter new status (1 or 2): ");

        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            book.setAvailabilityStatus("Available");
        } else if (choice == 2) {
            book.setAvailabilityStatus("Checked Out");
        } else {
            System.out.println("Invalid choice. Status remains unchanged.");
            return;
        }
        System.out.println("Availability status updated successfully!");
    }

    public void deleteBook() {
        System.out.println("\n--- Delete a Book ---");
        System.out.print("Enter Book ID to delete: ");
        String id = scanner.nextLine();

        Book bookToDelete = null;
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                bookToDelete = book;
                break;
            }
        }

        if (bookToDelete == null) {
            System.out.println("Book not found with ID: " + id);
            return;
        }

        System.out.println("Book to delete:");
        System.out.println(bookToDelete);
        System.out.print("Are you sure you want to delete this book? (yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            books.remove(bookToDelete);
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    private boolean isBookIdExists(String id) {
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
}
