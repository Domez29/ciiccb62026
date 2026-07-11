import java.util.Scanner;

public class WordCount {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask the user to enter a sentence
        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();

        // Remove extra spaces and split the sentence into words
        sentence = sentence.trim();

        if (sentence.isEmpty()) {
            System.out.println("Number of words: 0");
        } else {
            String[] words = sentence.split("\\s+");
            System.out.println("Number of words: " + words.length);
        }

        input.close();
    }
}
