public class MutiplicationTable {
    public static void main(String[] args) {

        System.out.println("10 x 10 Multiplication Table\n");

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }
}
