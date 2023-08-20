import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
 
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

public class CRUDApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("CRUD Application");
            System.out.println("================");

            System.out.println("1. Create a book");
            System.out.println("2. Read all books");
            System.out.println("3. Update a book");
            System.out.println("4. Delete a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    books.add(new Book(title, author));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.println("List of books:");
                    for (int i = 0; i < books.size(); i++) {
                        Book book = books.get(i);
                        System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor());
                    }
                    break;

                case 3:
                    System.out.print("Enter the index of the book to update: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine(); 

                    if (updateIndex >= 1 && updateIndex <= books.size()) {
                        Book bookToUpdate = books.get(updateIndex - 1);
                        System.out.print("Enter new title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter new author: ");
                        String newAuthor = scanner.nextLine();
                        bookToUpdate = new Book(newTitle, newAuthor);
                        books.set(updateIndex - 1, bookToUpdate);
                        System.out.println("Book updated successfully!");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the index of the book to delete: ");
                    int deleteIndex = scanner.nextInt();
                    if (deleteIndex >= 1 && deleteIndex <= books.size()) {
                        books.remove(deleteIndex - 1);
                        System.out.println("Book deleted successfully!");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}