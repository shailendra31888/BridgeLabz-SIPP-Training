package Encapsulation_Polymorphism;

interface Deliverable {
    void deliver();
}

abstract class FoodItem implements Deliverable {
    private String name;
    private double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.println("Item: " + name);
        System.out.println("Price: Rs." + price);
    }

    public abstract void deliver();
}

class Pizza extends FoodItem {
    private String size;

    public Pizza(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    @Override
    public void deliver() {
        System.out.println("Delivering pizza: " + getName() + " [" + size + "]");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Pizza");
        System.out.println("Size: " + size);
    }
}

class Burger extends FoodItem {
    private boolean isCheese;

    public Burger(String name, double price, boolean isCheese) {
        super(name, price);
        this.isCheese = isCheese;
    }

    @Override
    public void deliver() {
        System.out.println("Delivering burger: " + getName() + (isCheese ? " with cheese" : ""));
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Burger");
        System.out.println("Cheese: " + (isCheese ? "Yes" : "No"));
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem item1 = new Pizza("Margherita", 299, "Medium");
        FoodItem item2 = new Burger("Veg Burger", 149, true);

        item1.displayDetails();
        item1.deliver();
        System.out.println("-----------");
        item2.displayDetails();
        item2.deliver();
    }
}
