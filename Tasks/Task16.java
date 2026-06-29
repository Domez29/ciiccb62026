package Tasks;

public class Task16 {
    interface Animal {
    Boolean feed(Boolean timeToEat);
    void groom();
    void pet();
}

public class Gorilla implements Animal {

    @Override
    public Boolean feed(Boolean timeToEat) {
        // put gorilla food into cage
        if (timeToEat) {
            System.out.println("Gorilla is eating the food.");
            return true;
        }
        return false;
    }

    @Override
    public void groom() {
        // lather, rinse, repeat
        System.out.println("Gorilla is grooming.");
    }

    @Override
    public void pet() {
        // pet at your own risk
        System.out.println("Attempting to pet the gorilla...");
    }
}
}
