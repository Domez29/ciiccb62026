import java.util.Scanner;

public class SumAverageArray {
public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask the user for the number of elements
        System.out.print("Enter the number of elements: ");
        int n = input.nextInt();

        int[] numbers = new int[n];
        int sum = 0;
        double average;

        // Input array elements
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
            sum += numbers[i];
        }

        // Calculate average
        average = (double) sum / n;

        // Display the array
        System.out.print("\nArray elements: ");
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }

        // Display results
        System.out.println("\nSum = " + sum);
        System.out.println("Average = " + average);

        input.close();
    }
}
