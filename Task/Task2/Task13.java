package Task.Task2;

// 1. Create a base class called Vehicle with the fallowing attributes:
// make (string): the make of vehicle
// model (string): the model of the vehicle
// year (int): the manufacturing year of the vehicle
// 2. Create a derived class called car that extend the Vehicle class. The car class Should have an additional attributes:
// number of doors (int): The number of doors in the car.
// 3. Create an instance of the Car class and set values for its attributes.
// 4. Implement a method in the Car class called display details() that print out the details of the car, including the inherited attributes from the Vehicle class.

public class Task13 {
    
    // 1. Create a base class called Vehicle
class Vehicle {
    // Attributes for the base class
    String make;
    String model;
    int year;

    // Constructor to initialize Vehicle attributes
    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
}

// 2. Create a derived class called Car that extends the Vehicle class
class Car extends Vehicle {
    // Additional attribute specific to Car
    int numberOfDoors;

    // Constructor initializing both inherited and subclass attributes
    public Car(String make, String model, int year, int numberOfDoors) {
        // 'super' passes the inherited attributes to the Vehicle constructor
        super(make, model, year); 
        this.numberOfDoors = numberOfDoors;
    }

    // 4. Implement a method in the Car class called displayDetails()
    public void displayDetails() {
        System.out.println("--- Car Details ---");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}

// Main class to run and test the implementation
public class Main {
    public static void main(String[] args) {
        // 3. Create an instance of the Car class and set values for its attributes
        Car myCar = new Car("Mitsubishi", "Expander", 2026, 5);

        // Call the method to display details
        myCar.displayDetails();
    }
}
}
