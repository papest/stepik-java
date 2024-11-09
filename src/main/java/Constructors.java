public class Constructors {
    private final int value;

    public Constructors() {
        this(1);
    }

    public Constructors(int value) {
        this.value = value;
    }

    public long fact() {
        long product = 1;

        for (int current = 1; current <= value; current++) {
            product *= current;
        }
        return product;
    }

    public static void main(String[] args) {
        System.err.println(new Constructors(5).fact() / new Constructors(3).fact() * new Constructors().fact());
    }
}