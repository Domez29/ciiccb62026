package Tasks.Task15;

import Tasks.Task15.Task15Num1.Shape;
import Tasks.Task15.Task15Num3.Circle;
import Tasks.Task15.Task15Num3.Rectangle;

//4. In the class:
   //Create instances of Circle and rectangle.
  // Display their areas and perimeters
   
public class Task15Num4 {
    public class Main {
    public static void main(String[] args) {
        // Create instances
        Shape myCircle = new Circle("Red", 5.0);
        Shape myRectangle = new Rectangle("Blue", 4.0, 6.0);

        // Display Circle Details
        System.out.println("--- Circle Properties ---");
        System.out.println("Area: " + String.format("%.2f", myCircle.calculateArea()));
        System.out.println("Perimeter: " + String.format("%.2f", myCircle.calculatePerimeter()));
        
        System.out.println();

        // Display Rectangle Details
        System.out.println("--- Rectangle Properties ---");
        System.out.println("Area: " + myRectangle.calculateArea());
        System.out.println("Perimeter: " + myRectangle.calculatePerimeter());
    }
}
}
