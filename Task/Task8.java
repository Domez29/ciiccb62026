package Task;

public class Task8 {
    // Variable arguments method
    public static int calculateSum(int... numbers) {
        int totalSum = 0;

        for (int num : numbers) {
            int cumulativeSum = 0;

            for (int i = 1; i <= num; i++) {
                cumulativeSum += i;
            }

            System.out.println("Sum from 1 to " + num + " = " + cumulativeSum);
            totalSum += cumulativeSum;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int result = calculateSum(4, 5, 10);

        System.out.println("Total Sum = " + result);
    }
}
