import java.util.Scanner;

public class task5 {

     public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Input three numbers
        System.out.print("Enter three numbers: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();

        // Check if all numbers are equal
        if (num1 == num2 && num2 == num3) {
            System.out.println("All numbers are equal");
        }
        // Find the largest number
        else if (num1 >= num2 && num1 >= num3) {
            System.out.println("The largest number is " + num1);
        }
        else if (num2 >= num1 && num2 >= num3) {
            System.out.println("The largest number is " + num2);
        }
        else {
            System.out.println("The largest number is " + num3);
        }

        input.close();
    }
    
}
