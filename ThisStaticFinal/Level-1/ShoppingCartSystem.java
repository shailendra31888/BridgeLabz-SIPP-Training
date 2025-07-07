public class ShoppingCartSystem {
    private static double discount = 0.1;
    private final String productID;
    private String productName;
    private double price;

    public ShoppingCartSystem(String productName, double price, String productID) {
        this.productName = productName;
        this.price = price;
        this.productID = productID;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayDetails() {
        if (this instanceof ShoppingCartSystem) {
            System.out.println("Product Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Product ID: " + productID);
        }
    }

    public static void main(String[] args) {
        ShoppingCartSystem product1 = new ShoppingCartSystem("Laptop", 1000, "P001");
        product1.displayDetails();
        ShoppingCartSystem product2 = new ShoppingCartSystem("Smartphone", 500, "P002");
        product2.displayDetails();
    }
}