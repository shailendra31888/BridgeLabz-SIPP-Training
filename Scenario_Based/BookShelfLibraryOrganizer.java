import java.util.*;

class Book {
    String title;
    String author;
    String genre;
    int bookId;

    public Book(String title, String author, String genre, int bookId) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "[" + bookId + "] " + title + " by " + author;
    }
}

class BookShelf {
    // genre -> list of books
    private Map<String, LinkedList<Book>> genreCatalog = new HashMap<>();
    // Optional: avoid duplication
    private Set<Integer> bookIds = new HashSet<>();

    // Add a book
    public void addBook(Book book) {
        if (bookIds.contains(book.bookId)) {
            System.out.println("Duplicate book ID not allowed: " + book.bookId);
            return;
        }
        genreCatalog.putIfAbsent(book.genre, new LinkedList<>());
        genreCatalog.get(book.genre).add(book);
        bookIds.add(book.bookId);
    }

    // Remove a book by ID
    public void removeBook(int bookId) {
        for (LinkedList<Book> list : genreCatalog.values()) {
            Iterator<Book> it = list.iterator();
            while (it.hasNext()) {
                Book b = it.next();
                if (b.bookId == bookId) {
                    it.remove();
                    bookIds.remove(bookId);
                    System.out.println("Removed book: " + b);
                    return;
                }
            }
        }
        System.out.println("Book ID not found: " + bookId);
    }

    // Borrow a book (remove from shelf)
    public void borrowBook(int bookId) {
        removeBook(bookId);
    }

    // Return a book (add to shelf)
    public void returnBook(Book book) {
        addBook(book);
    }

    // Display all books by genre
    public void displayByGenre(String genre) {
        LinkedList<Book> list = genreCatalog.get(genre);
        if (list == null || list.isEmpty()) {
            System.out.println("No books in genre: " + genre);
            return;
        }
        System.out.println("Books in genre '" + genre + "':");
        for (Book b : list) {
            System.out.println(b);
        }
    }

    // Display all books
    public void displayAll() {
        for (String genre : genreCatalog.keySet()) {
            displayByGenre(genre);
        }
    }
}

public class BookShelfLibraryOrganizer {
    public static void main(String[] args) {
        BookShelf shelf = new BookShelf();

        shelf.addBook(new Book("Harry Potter", "J.K. Rowling", "Fantasy", 101));
        shelf.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 102));
        shelf.addBook(new Book("Clean Code", "Robert Martin", "Education", 201));
        shelf.addBook(new Book("Java Programming", "James Gosling", "Education", 202));

        shelf.displayAll();

        System.out.println("\nBorrow book ID 101:");
        shelf.borrowBook(101);
        shelf.displayByGenre("Fantasy");

        System.out.println("\nReturn book ID 101:");
        shelf.returnBook(new Book("Harry Potter", "J.K. Rowling", "Fantasy", 101));
        shelf.displayByGenre("Fantasy");

        System.out.println("\nTry to add duplicate book ID 101:");
        shelf.addBook(new Book("Harry Potter", "J.K. Rowling", "Fantasy", 101));
    }
}