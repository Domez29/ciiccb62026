import java.util.Scanner;

public class StringBuilderOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string (at least 10 characters): ");
        String str = input.nextLine();

        if (str.length() < 10) {
            System.out.println("Error: Please enter a string with at least 10 characters.");
            input.close();
            return;
        }

        StringBuilder sb = new StringBuilder(str);

        // 1. Print the length of the string
        System.out.println("1. Length: " + sb.length());

        // 2. Print the first character
        System.out.println("2. First character: " + sb.charAt(0));

        // 3. Print the last character
        System.out.println("3. Last character: " + sb.charAt(sb.length() - 1));

        // 4. Print the index of the first occurrence of 'a'
        System.out.println("4. Index of first 'a': " + sb.indexOf("a"));

        // 5. Print the substring from index 3 to index 6
        System.out.println("5. Substring (3 to 6): " + sb.substring(3, 7));

        // 6. Append "123"
        sb.append("123");
        System.out.println("6. After append: " + sb);

        // 7. Insert "xyz" at index 4
        sb.insert(4, "xyz");
        System.out.println("7. After insert: " + sb);

        // 8. Delete substring from index 2 to index 4
        sb.delete(2, 5);
        System.out.println("8. After delete: " + sb);

        // 9. Delete the character at index 8
        if (sb.length() > 8) {
            sb.deleteCharAt(8);
        }
        System.out.println("9. After deleteCharAt: " + sb);

        // 10. Reverse the string
        sb.reverse();
        System.out.println("10. Reversed string: " + sb);

        input.close();
    }
}
