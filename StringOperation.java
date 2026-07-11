import java.util.Scanner;

public class StringOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask the user to enter a string
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        // 1. Print the length of the string
        System.out.println("Length: " + str.length());

        // 2. Convert to uppercase
        System.out.println("Uppercase: " + str.toUpperCase());

        // 3. Convert to lowercase
        System.out.println("Lowercase: " + str.toLowerCase());

        // 4. Print the first character
        System.out.println("First character: " + str.charAt(0));

        // 5. Print the last character
        System.out.println("Last character: " + str.charAt(str.length() - 1));

        // 6. Print the substring from the second character to the fifth character
        if (str.length() >= 5) {
            System.out.println("Substring (2nd to 5th character): " + str.substring(1, 5));
        } else {
            System.out.println("The string is too short to extract characters 2 to 5.");
        }

        input.close();
    }
}
