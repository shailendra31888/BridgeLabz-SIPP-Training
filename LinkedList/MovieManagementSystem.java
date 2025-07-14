class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieDoublyLinkedList {
    private MovieNode head;
    private MovieNode tail;

    // Add at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add at end
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }
        
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Remove by Movie Title
    public void removeByTitle(String title) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                } else if (temp == tail) {
                    tail = temp.prev;
                    if (tail != null) tail.next = null;
                    else head = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }

    // Search by Director
    public void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found for director: " + director);
    }

    // Search by Rating
    public void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    // Update Rating by Title
    public boolean updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Display all movies forward
    public void displayForward() {
        MovieNode temp = head;
        if (temp == null) {
            System.out.println("No movies in the list.");
            return;
        }
        while (temp != null) {
            printMovie(temp);
            temp = temp.next;
        }
    }

    // Display all movies in reverse
    public void displayReverse() {
        MovieNode temp = tail;
        if (temp == null) {
            System.out.println("No movies in the list.");
            return;
        }
        while (temp != null) {
            printMovie(temp);
            temp = temp.prev;
        }
    }

    private void printMovie(MovieNode node) {
        System.out.println("Title: " + node.title + ", Director: " + node.director +
                ", Year: " + node.year + ", Rating: " + node.rating);
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieDoublyLinkedList movies = new MovieDoublyLinkedList();

        // Sample usage
        movies.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movies.addAtEnd("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        movies.addAtPosition(2, "Interstellar", "Christopher Nolan", 2014, 8.6);

        System.out.println("All movies (forward):");
        movies.displayForward();

        System.out.println("\nAll movies (reverse):");
        movies.displayReverse();

        System.out.println("\nSearching for movies by director 'Christopher Nolan':");
        movies.searchByDirector("Christopher Nolan");

        System.out.println("\nSearching for movies with rating 9.2:");
        movies.searchByRating(9.2);

        System.out.println("\nUpdating rating for 'Inception':");
        if (movies.updateRating("Inception", 9.0)) {
            System.out.println("Rating updated.");
        } else {
            System.out.println("Movie not found.");
        }
        movies.displayForward();

        System.out.println("\nRemoving 'The Godfather':");
        movies.removeByTitle("The Godfather");
        movies.displayForward();
    }
}