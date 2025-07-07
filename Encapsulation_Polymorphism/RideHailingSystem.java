package Encapsulation_Polymorphism;

interface FareCalculable {
    double calculateFare();
}

abstract class Ride implements FareCalculable {
    private String riderName;
    private double distance;

    public Ride(String riderName, double distance) {
        this.riderName = riderName;
        this.distance = distance;
    }

    public String getRiderName() {
        return riderName;
    }

    public double getDistance() {
        return distance;
    }

    public void displayRideInfo() {
        System.out.println("Rider: " + riderName);
        System.out.println("Distance: " + distance + " km");
    }

    public abstract double calculateFare();
}

class AutoRide extends Ride {
    private double ratePerKm = 12;

    public AutoRide(String riderName, double distance) {
        super(riderName, distance);
    }

    @Override
    public double calculateFare() {
        return getDistance() * ratePerKm;
    }

    @Override
    public void displayRideInfo() {
        super.displayRideInfo();
        System.out.println("Vehicle: Auto");
        System.out.println("Fare: Rs." + calculateFare());
    }
}

class CabRide extends Ride {
    private double ratePerKm = 20;

    public CabRide(String riderName, double distance) {
        super(riderName, distance);
    }

    @Override
    public double calculateFare() {
        return getDistance() * ratePerKm;
    }

    @Override
    public void displayRideInfo() {
        super.displayRideInfo();
        System.out.println("Vehicle: Cab");
        System.out.println("Fare: Rs." + calculateFare());
    }
}

public class RideHailingSystem {
    public static void main(String[] args) {
        Ride ride1 = new AutoRide("Pragya", 8.5);
        Ride ride2 = new CabRide("Neha", 10);

        ride1.displayRideInfo();
        System.out.println("-------------");
        ride2.displayRideInfo();
    }
}
