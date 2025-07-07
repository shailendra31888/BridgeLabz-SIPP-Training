import java.util.Scanner;

class MovieTicketBookingSystem{
    String movieName;
    String seatNumber;
    double price;

    MovieTicketBookingSystem(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    void bookTicket(String seat, double price) {
        this.seatNumber = seat;
        this.price = price;
    }

    void displayTicketDetails() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter movie name: ");
        String movieName = scanner.nextLine();
        MovieTicketBookingSystem ticket = new MovieTicketBookingSystem(movieName, "", 0);
        ticket.bookTicket("A1", 10.0);
        ticket.displayTicketDetails();
    }
}