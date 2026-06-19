package Task;

import static java.lang.Math.*;

public class Task9 {

    // Addition
    public static int add(int a, int b) {
        return addExact(a, b);
    }

    // Subtraction
    public static int subtract(int a, int b) {
        return subtractExact(a, b);
    }

    // Multiplication
    public static int multiply(int a, int b) {
        return multiplyExact(a, b);
    }

    // Division
    public static int divide(int a, int b) {
        return floorDiv(a, b);
    }

    public static void main(String[] args) {

        System.out.println("Addition: " + add(10, 5));
        System.out.println("Subtraction: " + subtract(10, 5));
        System.out.println("Multiplication: " + multiply(10, 5));
        System.out.println("Division: " + divide(10, 5));

        System.out.println();

        System.out.println("Addition: " + add(20, 8));
        System.out.println("Subtraction: " + subtract(20, 8));
        System.out.println("Multiplication: " + multiply(20, 8));
        System.out.println("Division: " + divide(20, 8));
    }
}

