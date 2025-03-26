import java.util.Scanner;

public class DigitalLibraryApp {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Digital Library Book Management System ===");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search for a Book");
            System.out.println("4. Update Book Details");
            System.out.println("5. Delete a Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1-6.");
                continue;
            }

            switch (choice) {
                case 1:
                    libraryService.addBook();
                    break;
                case 2:
                    libraryService.viewAllBooks();
                    break;
                case 3:
                    libraryService.searchBook();
                    break;
                case 4:
                    libraryService.updateBook();
                    break;
                case 5:
                    libraryService.deleteBook();
                    break;
                case 6:
                    System.out.println("Thank you for using the Digital Library System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1-6.");
            }
        }
    }
}
