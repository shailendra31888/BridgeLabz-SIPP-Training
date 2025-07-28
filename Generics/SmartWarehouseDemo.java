
import java.util.*;

// Abstract base class for all warehouse items
abstract class WarehouseItem {

    private String name;
    private int id;

    public WarehouseItem(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract String getDetails();
}

// Electronics item
class Electronics extends WarehouseItem {

    private String brand;

    public Electronics(String name, int id, String brand) {
        super(name, id);
        this.brand = brand;
    }

    @Override
    public String getDetails() {
        return "Electronics: " + getName() + " (ID: " + getId() + "), Brand: " + brand;
    }
}

// Groceries item
class Groceries extends WarehouseItem {

    private String expiryDate;

    public Groceries(String name, int id, String expiryDate) {
        super(name, id);
        this.expiryDate = expiryDate;
    }

    @Override
    public String getDetails() {
        return "Groceries: " + getName() + " (ID: " + getId() + "), Expiry: " + expiryDate;
    }
}

// Furniture item
class Furniture extends WarehouseItem {

    private String material;

    public Furniture(String name, int id, String material) {
        super(name, id);
        this.material = material;
    }

    @Override
    public String getDetails() {
        return "Furniture: " + getName() + " (ID: " + getId() + "), Material: " + material;
    }
}

// Generic storage class
class Storage<T extends WarehouseItem> {

    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public List<T> getAllItems() {
        return items;
    }
}

// Utility to display any list of WarehouseItem (wildcard)
class WarehouseUtils {

    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getDetails());
        }
    }
}

public class SmartWarehouseDemo {

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop", 101, "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", 102, "Samsung"));

        groceriesStorage.addItem(new Groceries("Milk", 201, "2025-08-01"));
        groceriesStorage.addItem(new Groceries("Bread", 202, "2025-07-25"));

        furnitureStorage.addItem(new Furniture("Chair", 301, "Wood"));
        furnitureStorage.addItem(new Furniture("Table", 302, "Metal"));

        System.out.println("All Electronics:");
        WarehouseUtils.displayAllItems(electronicsStorage.getAllItems());

        System.out.println("\nAll Groceries:");
        WarehouseUtils.displayAllItems(groceriesStorage.getAllItems());

        System.out.println("\nAll Furniture:");
        WarehouseUtils.displayAllItems(furnitureStorage.getAllItems());
    }
}
