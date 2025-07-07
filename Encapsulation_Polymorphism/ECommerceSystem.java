package Encapsulation_Polymorphism;

interface Discountable {
    double getDiscountedPrice();
}

abstract class Product implements Discountable {
    private String name;
    private double price;
    private int productId;

    public Product(String name, double price, int productId) {
        this.name = name;
        this.price = price;
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getProductId() {
        return productId;
    }

    public void displayInfo() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: ₹" + price);
    }

    public abstract double getDiscountedPrice();
}

class Electronics extends Product {
    private int warrantyInYears;

    public Electronics(String name, double price, int productId, int warrantyInYears) {
        super(name, price, productId);
        this.warrantyInYears = warrantyInYears;
    }

    @Override
    public double getDiscountedPrice() {
        return getPrice() * 0.9; 
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Category: Electronics");
        System.out.println("Warranty: " + warrantyInYears + " years");
        System.out.println("Discounted Price: ₹" + getDiscountedPrice());
    }
}

class Clothing extends Product {
    private String size;

    public Clothing(String name, double price, int productId, String size) {
        super(name, price, productId);
        this.size = size;
    }

    @Override
    public double getDiscountedPrice() {
        return getPrice() * 0.85; // 15% discount
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Category: Clothing");
        System.out.println("Size: " + size);
        System.out.println("Discounted Price: ₹" + getDiscountedPrice());
    }
}

public class ECommerceSystem {
    public static void main(String[] args) {
        Product p1 = new Electronics("Smartphone", 30000, 201, 2);
        Product p2 = new Clothing("T-Shirt", 1200, 202, "M");

        p1.displayInfo();
        System.out.println("-----------");
        p2.displayInfo();
    }
}
