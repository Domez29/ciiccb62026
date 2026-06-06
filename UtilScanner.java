import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Input three numbers
        System.out.print("Enter firs: ");
        int num1 = input.nextInt();

        System.out.print("Enter second number: ");
        int num2 = input.nextInt();

        System.out.print("Enter third number: ");
        int num3 = input.nextInt();

        // Check if all numbers are equal
        if (num1 == num2 && num2 == num3) {
            System.out.println("All numbers are equal.");
        } else {
            // Find the largest number
            int largest = num1;

            if (num2 > largest) {
                largest = num2;
            }

            if (num3 > largest) {
                largest = num3;
            }

            System.out.println("The largest number is " + largest);
        }

        input.close();
    }
}