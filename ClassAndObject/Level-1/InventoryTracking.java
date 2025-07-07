public class InventoryTracking{
    String itemCode;
    String itemName;
    double price;

    public InventoryTracking(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Item Code: " + itemCode + ", Item Name: " + itemName + ", Price: " + price);
    }

    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        InventoryTracking item = new InventoryTracking("A001", "Laptop", 1500);
        item.displayDetails();
        System.out.println("Total Cost for 3 items: " + item.calculateTotalCost(3));
    }
}