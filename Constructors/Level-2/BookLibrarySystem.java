public class BookLibrarySystem {
    public String ISBN;
    protected String title;
    private String author;

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public static void main(String[] args) {
        BookLibrarySystem book = new BookLibrarySystem();
        book.ISBN = "978-3-16-148410-0";
        book.title = "Java Programming";
        book.setAuthor("John Doe");
        System.out.println("Book ISBN: " + book.ISBN);
        System.out.println("Book Title: " + book.title);
        System.out.println("Book Author: " + book.getAuthor());
    }
}