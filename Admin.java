public class Admin extends User {

    public Admin(int userId, String name, String email) {
        super(userId, name, email);
    }

    @Override
    public void showRole() {
        System.out.println("I am the Library Admin.");
    }

    // Admin adds a book to the library
    public void addBook(Library library, Book book) {
        library.addBook(book);
    }

    // Admin removes a book from the library
    public void removeBook(Library library, int bookId) {
        library.removeBook(bookId);
    }
}
