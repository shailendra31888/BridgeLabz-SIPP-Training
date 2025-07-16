
class Flavor {

    String name;
    int sales;

    public Flavor(String name, int sales) {
        this.name = name;
        this.sales = sales;
    }

    @Override
    public String toString() {
        return name + " (" + sales + ")";
    }
}

public class IceCreamRush {

    // Bubble Sort flavors by sales (descending)
    public static void bubbleSort(Flavor[] flavors) {
        int n = flavors.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (flavors[j].sales < flavors[j + 1].sales) {
                    // Swap
                    Flavor temp = flavors[j];
                    flavors[j] = flavors[j + 1];
                    flavors[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Flavor[] flavors = {
            new Flavor("Vanilla", 120),
            new Flavor("Chocolate", 150),
            new Flavor("Strawberry", 90),
            new Flavor("Mango", 110),
            new Flavor("Pistachio", 80),
            new Flavor("Blueberry", 60),
            new Flavor("Coffee", 100),
            new Flavor("Butterscotch", 130)
        };

        System.out.println("Before sorting:");
        for (Flavor f : flavors) {
            System.out.println(f);
        }

        bubbleSort(flavors);

        System.out.println("\nAfter sorting by popularity:");
        for (Flavor f : flavors) {
            System.out.println(f);
        }
    }
}
