public class Book {
    // encapsulation: by keeping data private
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    // constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    // getter methods
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    // setter method
    public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    // overriding toString to print book description
    @Override
    public String toString() {
        return id + ". \"" + title + "\" by " + author + (isIssued ? " [Issued]" : " [Available]");
    }
}
