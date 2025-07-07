package Encapsulation_Polymorphism;

interface Borrowable {
    void borrow();
    void returnItem();
}

abstract class Item implements Borrowable {
    private String title;
    private String itemId;
    protected boolean isBorrowed;

    public Item(String title, String itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getItemId() {
        return itemId;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void displayInfo() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Status: " + (isBorrowed ? "Borrowed" : "Available"));
    }

    public abstract void borrow();
    public abstract void returnItem();
}

class Book extends Item {
    private String author;

    public Book(String title, String itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public void borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Book \"" + getTitle() + "\" borrowed successfully.");
        } else {
            System.out.println("Book \"" + getTitle() + "\" is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Book \"" + getTitle() + "\" returned successfully.");
        } else {
            System.out.println("Book \"" + getTitle() + "\" was not borrowed.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + author);
        System.out.println("Type: Book");
    }
}

class Magazine extends Item {
    private int issueNumber;

    public Magazine(String title, String itemId, int issueNumber) {
        super(title, itemId);
        this.issueNumber = issueNumber;
    }

    @Override
    public void borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Magazine \"" + getTitle() + "\" borrowed.");
        } else {
            System.out.println("Magazine \"" + getTitle() + "\" is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Magazine \"" + getTitle() + "\" returned.");
        } else {
            System.out.println("Magazine \"" + getTitle() + "\" was not borrowed.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Type: Magazine");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Item b1 = new Book("The Alchemist", "B101", "Paulo Coelho");
        Item m1 = new Magazine("National Geographic", "M201", 156);

        b1.displayInfo();
        b1.borrow();
        b1.borrow(); 
        b1.returnItem();
        System.out.println("-----------");

        m1.displayInfo();
        m1.borrow();
        m1.returnItem();
    }
}

