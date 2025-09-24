import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Remove book by ID
    public void removeBook(int id) {
        Book toRemove = null;
        for (Book b : books) {
            if (b.getId() == id) {
                toRemove = b;
                break;
            }
        }
        if (toRemove != null) {
            books.remove(toRemove);
            System.out.println("Book removed: " + toRemove.getTitle());
        } else {
            System.out.println("Book ID not found.");
        }
    }

    // List all books
    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // Check availability
    public boolean isBookAvailable(int id) {
        for (Book b : books) {
            if (b.getId() == id && !b.isIssued()) {
                return true;
            }
        }
        return false;
    }

    // Get book by ID
    public Book getBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public void searchBooks(String keyword) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books matched your search.");
        }
    }

}
