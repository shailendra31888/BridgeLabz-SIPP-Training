public class CircleAreaComputation {
    double radius;

    public CircleAreaComputation(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public void display() {
        System.out.println("Area: " + calculateArea() + ", Circumference: " + calculateCircumference());
    }

    public static void main(String[] args) {
        CircleAreaComputation circle = new CircleAreaComputation(5);
        circle.display();
    }
}