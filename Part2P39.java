import java.util.Scanner;

public class Part2P39 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter three numbers: ");

        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();

        if (num1 == num2 && num2 == num3) {
            System.out.println("All numbers are equal");
        } else {
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
