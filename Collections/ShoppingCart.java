
import java.util.*;

public class ShoppingCart {

    private Map<String, Double> priceMap = new HashMap<>();
    private LinkedHashMap<String, Double> cartOrderMap = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedCartMap = new TreeMap<>();

    // Add product with price to cart
    public void addProduct(String product, double price) {
        priceMap.put(product, price);
        cartOrderMap.put(product, price);
        sortedCartMap.put(price, product);
    }

    // Display items in order added (LinkedHashMap)
    public void displayCartOrder() {
        System.out.println("Cart items in order added (LinkedHashMap):");
        for (Map.Entry<String, Double> entry : cartOrderMap.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    // Display items sorted by price (TreeMap)
    public void displaySortedByPrice() {
        System.out.println("Cart items sorted by price (TreeMap):");
        for (Map.Entry<Double, String> entry : sortedCartMap.entrySet()) {
            System.out.println(entry.getValue() + ": $" + entry.getKey());
        }
    }

    // Display all product prices (HashMap)
    public void displayAllPrices() {
        System.out.println("All product prices (HashMap):");
        for (Map.Entry<String, Double> entry : priceMap.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Apple", 1.5);
        cart.addProduct("Bread", 2.0);
        cart.addProduct("Milk", 1.2);
        cart.addProduct("Eggs", 2.5);

        cart.displayAllPrices();
        cart.displayCartOrder();
        cart.displaySortedByPrice();
    }
}
