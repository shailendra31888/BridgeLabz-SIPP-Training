public class ProductInventory {
    private String productName;
    private double price;
    private static int totalProducts = 0;

    public ProductInventory(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    public void displayProductDetails() {
        System.out.println("Product Name: " + productName + ", Price: $" + price);
    }

    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        ProductInventory product1 = new ProductInventory("Laptop", 999.99);
        ProductInventory product2 = new ProductInventory("Smartphone", 499.99);
        product1.displayProductDetails();
        product2.displayProductDetails();
        ProductInventory.displayTotalProducts();
    }
}