package Tasks.Task15;

//3. Implement two concrete classes that extend abtractShape:
   //Circle: Representing a circle. Include a radius as a attribute.
   //Rectangle: Representing a rectangle. Include length and width as attributes.


import Tasks.Task15.Task15Num2.AbstractShape;

public class Task15Num3 {
    public class Circle extends AbstractShape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius; // Perimeter (Circumference) of a circle
    }
}
//Rectangle
//Java
public class Rectangle extends AbstractShape {
    private double length;
    private double width;

    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}
}
