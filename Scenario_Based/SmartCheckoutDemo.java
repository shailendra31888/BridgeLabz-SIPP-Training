
import java.util.*;

class Customer {

    String name;
    List<String> items;

    public Customer(String name, List<String> items) {
        this.name = name;
        this.items = items;
    }
}

class SmartCheckout {

    private Queue<Customer> queue = new LinkedList<>();
    private Map<String, Double> priceMap = new HashMap<>();
    private Map<String, Integer> stockMap = new HashMap<>();

    // Add item to price and stock map
    public void addItem(String item, double price, int stock) {
        priceMap.put(item, price);
        stockMap.put(item, stock);
    }

    // Add customer to queue
    public void addCustomer(Customer customer) {
        queue.offer(customer);
        System.out.println("Added customer: " + customer.name);
    }

    // Remove customer from queue (after checkout)
    public void removeCustomer() {
        Customer customer = queue.poll();
        if (customer != null) {
            System.out.println("Processing checkout for: " + customer.name);
            double total = 0;
            for (String item : customer.items) {
                Double price = priceMap.get(item);
                Integer stock = stockMap.get(item);
                if (price == null || stock == null || stock == 0) {
                    System.out.println("Item unavailable: " + item);
                } else {
                    total += price;
                    stockMap.put(item, stock - 1);
                    System.out.println("Purchased: " + item + " for $" + price);
                }
            }
            System.out.println("Total bill for " + customer.name + ": $" + total);
        } else {
            System.out.println("No customers in queue.");
        }
    }

    // Display queue
    public void displayQueue() {
        System.out.println("Current queue:");
        for (Customer c : queue) {
            System.out.println(c.name + " - " + c.items);
        }
    }

    // Display stock
    public void displayStock() {
        System.out.println("Current stock:");
        for (String item : stockMap.keySet()) {
            System.out.println(item + ": " + stockMap.get(item));
        }
    }
}

public class SmartCheckoutDemo {

    public static void main(String[] args) {
        SmartCheckout checkout = new SmartCheckout();

        // Add items to price and stock map
        checkout.addItem("Apple", 1.0, 10);
        checkout.addItem("Bread", 2.5, 5);
        checkout.addItem("Milk", 3.0, 8);

        // Add customers
        checkout.addCustomer(new Customer("Alice", Arrays.asList("Apple", "Milk")));
        checkout.addCustomer(new Customer("Bob", Arrays.asList("Bread", "Apple", "Apple")));
        checkout.addCustomer(new Customer("Charlie", Arrays.asList("Milk", "Bread")));

        checkout.displayQueue();
        checkout.displayStock();

        // Process checkout for each customer
        checkout.removeCustomer();
        checkout.displayStock();

        checkout.removeCustomer();
        checkout.displayStock();

        checkout.removeCustomer();
        checkout.displayStock();

        checkout.removeCustomer(); // No customers left
    }
}
