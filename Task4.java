import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

        // Ask the user for input
        System.out.print("Enter a word or number: ");
        String text = input.nextLine();

        // Reverse the input using StringBuilder
        String reversed = new StringBuilder(text).reverse().toString();

        // Check if the original and reversed strings are equal
        if (text.equals(reversed)) {
            System.out.println("The input string is a palindrome.");
        } else {
            System.out.println("The input string is not a palindrome.");
        }

        input.close();  

        
    }
}
