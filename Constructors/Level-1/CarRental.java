public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private static final double DAILY_RATE = 50.0;

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * DAILY_RATE;
    }

    public static void main(String[] args) {
        CarRental rental = new CarRental("Jane Smith", "Toyota Camry", 5);
        System.out.println("Total cost for rental: $" + rental.calculateTotalCost());
    }
}