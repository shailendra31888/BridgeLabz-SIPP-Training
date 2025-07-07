package Encapsulation_Polymorphism;
interface Rentable {
    double calculateRental(int days);
}

abstract class Vehicle implements Rentable {
    private String model;
    private String numberPlate;

    public Vehicle(String model, String numberPlate) {
        this.model = model;
        this.numberPlate = numberPlate;
    }

    public String getModel() {
        return model;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Number Plate: " + numberPlate);
    }

    public abstract double calculateRental(int days);
}

class Car extends Vehicle {
    private double rentPerDay;

    public Car(String model, String numberPlate, double rentPerDay) {
        super(model, numberPlate);
        this.rentPerDay = rentPerDay;
    }

    @Override
    public double calculateRental(int days) {
        return rentPerDay * days;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle Type: Car");
        System.out.println("Rent per day: ₹" + rentPerDay);
    }
}

class Bike extends Vehicle {
    private double rentPerHour;

    public Bike(String model, String numberPlate, double rentPerHour) {
        super(model, numberPlate);
        this.rentPerHour = rentPerHour;
    }

    @Override
    public double calculateRental(int days) {
        return rentPerHour * 24 * days; 
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle Type: Bike");
        System.out.println("Rent per hour: ₹" + rentPerHour);
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle car = new Car("Hyundai Creta", "UP32 AB 1234", 1500);
        Vehicle bike = new Bike("Royal Enfield", "UP32 XY 5678", 50);

        car.displayInfo();
        System.out.println("3-day rental: ₹" + car.calculateRental(3));
        System.out.println("------------");
        bike.displayInfo();
        System.out.println("3-day rental: ₹" + bike.calculateRental(3));
    }
}
