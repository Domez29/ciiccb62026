package Tasks.Task15;

//2. Create an abstract class called AbstractShape that implements the Shape interface. This class should have:
//Instance variables to represent common attributes of shapes.

//String color, double length, double width
 //  A constructor to initialize these attributes.
  // Implementations for the calculateArea anf calculatePerimeter methods.


import Tasks.Task15.Task15Num1.Shape;

public class Task15Num2 {
    public abstract class AbstractShape implements Shape {
    protected String color;

    // Constructor
    public AbstractShape(String color) {
        this.color = color;
    }

    // Getter for color
    public String getColor() {
        return color;
    }
}
}
