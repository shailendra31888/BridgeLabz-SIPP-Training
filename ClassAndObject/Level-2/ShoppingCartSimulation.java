import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ShoppingCartSimulation{
    String itemName;
    double price;
    int quantity;

    ShoppingCartSimulation(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    double totalCost() {
        return price * quantity;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ShoppingCartSimulation> cart = new ArrayList<>();
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();
        ShoppingCartSimulation item = new ShoppingCartSimulation(itemName, price, quantity);
        cart.add(item);
        double total = 0;
        for (ShoppingCartSimulation cartItem : cart) {
            total += cartItem.totalCost();
        }
        System.out.println("Total Cost: " + total);
    }
}