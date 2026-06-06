package Tasks;

public class task3 {
    public static void main(String[] args) {

        String a = new String("WOW");
        String b = "WOW";
        String c = a;
        String d = c;

        Boolean b1 = a.equals(b);
        Boolean b2 = d.equals(a);
        Boolean b3 = c.equals(b);

        if (b1 && b2 && b3) {
            System.out.println("Success!");
        }
    }
}
