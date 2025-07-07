package Encapsulation_Polymorphism;

interface Schedulable {
    void schedule();
}

abstract class Person implements Schedulable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract void schedule();
}

class Doctor extends Person {
    private String specialization;

    public Doctor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }

    @Override
    public void schedule() {
        System.out.println("Doctor " + getName() + " scheduled for appointments.");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Doctor");
        System.out.println("Specialization: " + specialization);
    }
}

class Patient extends Person {
    private String illness;

    public Patient(String name, int age, String illness) {
        super(name, age);
        this.illness = illness;
    }

    @Override
    public void schedule() {
        System.out.println("Patient " + getName() + " scheduled for checkup.");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Patient");
        System.out.println("Illness: " + illness);
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Person p1 = new Doctor("Dr. Ramesh", 45, "Cardiology");
        Person p2 = new Patient("Riya", 30, "Flu");

        p1.displayDetails();
        p1.schedule();
        System.out.println("-----------");
        p2.displayDetails();
        p2.schedule();
    }
}