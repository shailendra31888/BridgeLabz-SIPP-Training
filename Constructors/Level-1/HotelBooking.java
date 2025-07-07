public class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    HotelBooking() {
        this("Default Guest", "Single", 1);
    }

    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    HotelBooking(HotelBooking booking) {
        this.guestName = booking.guestName;
        this.roomType = booking.roomType;
        this.nights = booking.nights;
    }

    public void displayBooking() {
        System.out.println("Guest Name: " + guestName + ", Room Type: " + roomType + ", Nights: " + nights);
    }

    public static void main(String[] args) {
        HotelBooking booking1 = new HotelBooking();
        booking1.displayBooking();
        HotelBooking booking2 = new HotelBooking("John Doe", "Double", 3);
        booking2.displayBooking();
    }
}