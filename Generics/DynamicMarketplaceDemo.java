
import java.util.*;

// Category marker interfaces
interface BookCategory {
}

interface ClothingCategory {
}

interface GadgetCategory {
}

// Generic Product class with bounded type parameter
class Product<T> {

    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + category.getClass().getSimpleName() + ") - $" + price;
    }
}

// Example category implementations
class Fiction implements BookCategory {

    @Override
    public String toString() {
        return "Fiction";
    }
}

class NonFiction implements BookCategory {

    @Override
    public String toString() {
        return "NonFiction";
    }
}

class Men implements ClothingCategory {

    @Override
    public String toString() {
        return "Men";
    }
}

class Women implements ClothingCategory {

    @Override
    public String toString() {
        return "Women";
    }
}

class Smartphone implements GadgetCategory {

    @Override
    public String toString() {
        return "Smartphone";
    }
}

class Laptop implements GadgetCategory {

    @Override
    public String toString() {
        return "Laptop";
    }
}

// Generic method to apply discount
class MarketplaceUtils {

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double oldPrice = product.getPrice();
        double newPrice = oldPrice * (1 - percentage / 100.0);
        product.setPrice(newPrice);
        System.out.println("Discount applied to " + product.getName() + ": $" + oldPrice + " -> $" + newPrice);
    }
}

public class DynamicMarketplaceDemo {

    public static void main(String[] args) {
        // Create products of different categories
        Product<BookCategory> book1 = new Product<>("The Alchemist", 20.0, new Fiction());
        Product<BookCategory> book2 = new Product<>("Sapiens", 25.0, new NonFiction());
        Product<ClothingCategory> shirt = new Product<>("Formal Shirt", 30.0, new Men());
        Product<ClothingCategory> dress = new Product<>("Evening Dress", 50.0, new Women());
        Product<GadgetCategory> phone = new Product<>("Galaxy S25", 999.0, new Smartphone());
        Product<GadgetCategory> laptop = new Product<>("UltraBook X", 1500.0, new Laptop());

        // Catalog can hold any product type
        List<Product<?>> catalog = new ArrayList<>();
        catalog.add(book1);
        catalog.add(book2);
        catalog.add(shirt);
        catalog.add(dress);
        catalog.add(phone);
        catalog.add(laptop);

        System.out.println("Marketplace Catalog:");
        for (Product<?> p : catalog) {
            System.out.println(p);
        }

        // Apply discounts
        System.out.println("\nApplying discounts:");
        MarketplaceUtils.applyDiscount(book1, 10);
        MarketplaceUtils.applyDiscount(shirt, 20);
        MarketplaceUtils.applyDiscount(phone, 5);

        System.out.println("\nCatalog after discounts:");
        for (Product<?> p : catalog) {
            System.out.println(p);
        }
    }
}
