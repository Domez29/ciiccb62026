import java.util.Scanner;

public class OddEvenPositiveNegative {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        // Check if the number is zero
        if (number == 0) {
            System.out.println("The number is Zero.");
        } else {
            // Check if the number is positive or negative
            if (number > 0) {
                System.out.println("The number is Positive.");
            } else {
                System.out.println("The number is Negative.");
            }

            // Check if the number is odd or even
            if (number % 2 == 0) {
                System.out.println("The number is Even.");
            } else {
                System.out.println("The number is Odd.");
            }
        }

        input.close();
    }
}
