import java.util.Scanner;

public class SumofInteger {
public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many numbers do you want to enter? ");
        int n = input.nextInt();

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter integer " + i + ": ");
            int number = input.nextInt();
            sum += number;
        }

        System.out.println("The sum of all integers is: " + sum);

        input.close();
    }
}
