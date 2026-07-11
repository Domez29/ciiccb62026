import java.util.Scanner;

public class VowelsConsonants {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a letter: ");
        char ch = input.next().charAt(0);

        // Convert to lowercase
        ch = Character.toLowerCase(ch);

        // Check if the input is a letter
        if (Character.isLetter(ch)) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                System.out.println(ch + " is a Vowel.");
            } else {
                System.out.println(ch + " is a Consonant.");
            }
        } else {
            System.out.println("Invalid input! Please enter a letter.");
        }

        input.close();
    }
}
