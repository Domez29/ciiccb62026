package Task.Task2;

// write a new method in a Point called scale, that will make the closer by the half to (0,0). So for example (8,4) after scale will be (4,2).
public class Task12 {
    private int x;
    private int y;

    public Task12(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void scale() {
        x = x / 2;
        y = y / 2;
    }

    public void print() {
        System.out.println("(" + x + "," + y + ")");
    }

    public static void main(String[] args) {
        Task12 p = new Task12(8, 4);
        p.print();  // Output: (8,4)
        
        p.scale();
        p.print();  // Output: (4,2)
    }
}

