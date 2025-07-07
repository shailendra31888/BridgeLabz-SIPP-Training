public class Circle {
    private double radius;

    Circle() {
        this(1.0);
    }

    Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println("Circle 1 Area: " + circle1.getArea());
        Circle circle2 = new Circle(2.5);
        System.out.println("Circle 2 Area: " + circle2.getArea());
    }
}