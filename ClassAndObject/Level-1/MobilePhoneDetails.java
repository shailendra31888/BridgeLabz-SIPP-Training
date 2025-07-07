public class MobilePhoneDetails{
    String brand;
    String model;
    double price;

    public MobilePhoneDetails(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Price: " + price);
    }

    public static void main(String[] args) {
        MobilePhoneDetails phone = new MobilePhoneDetails("Apple", "iPhone 14", 999);
        phone.displayDetails();
    }
}