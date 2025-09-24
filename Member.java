import java.util.ArrayList;
import java.util.List;

public class Member extends User {
    private List<Book> issuedBooks;

    public Member(int userId, String name, String email) {
        super(userId, name, email);
        this.issuedBooks = new ArrayList<>();
    }

    @Override
    public void showRole() {
        System.out.println("I am a Library Member.");
    }

    public void borrowBook(Library library, int bookId) {
        Book book = library.getBookById(bookId);
        if (book != null && !book.isIssued()) {
            book.setIssued(true);
            issuedBooks.add(book);
            System.out.println("Book borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not available for issue.");
        }
    }

    public void returnBook(Library library, int bookId) {
        Book toReturn = null;
        for (Book b : issuedBooks) {
            if (b.getId() == bookId) {
                toReturn = b;
                break;
            }
        }

        if (toReturn != null) {
            toReturn.setIssued(false);
            issuedBooks.remove(toReturn);
            System.out.println("Book returned: " + toReturn.getTitle());
        } else {
            System.out.println("You have not borrowed this book.");
        }
    }

    public void showIssuedBooks() {
        if (issuedBooks.isEmpty()) {
            System.out.println("No books currently issued.");
        } else {
            System.out.println("Issued Books:");
            for (Book b : issuedBooks) {
                System.out.println(b);
            }
        }
    }
}
