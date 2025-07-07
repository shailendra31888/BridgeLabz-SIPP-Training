import java.util.Scanner;
public class BookDetails 
{
    private String title;
    private String author;
    private int price;

    BookDetails()
    {
        title = "2 bhelo ki katha";
        author = "Prem Chand";
        price = 250;
    }
    BookDetails(String title, String author, int price)
    {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayDetails()
    {
        System.out.println("Book title is: "+title);
        System.out.println("Book author is: "+author);
        System.out.println("Book price is: "+price);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        BookDetails book1 = new BookDetails();
        book1.displayDetails();

        BookDetails book2 = new BookDetails("Namak Ka Daroga", "Prem Chand", 220);
        book2.displayDetails();
        
    }
    
}