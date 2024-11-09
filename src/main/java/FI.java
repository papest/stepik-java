public class FI {
    @FunctionalInterface
    private interface Calculator {
        int process(int x, int y);
    }

    static void call(final Calculator calc, final int value1, final int value2) {
        System.err.print(calc.process(value1, value2));
    }

    static int add(final int value1, final int value2) {
        return value1 + value2;
    }

    static int sub(final int value1, final int value2) {
        return value1 - value2;
    }

    static int mul(final int value1, final int value2) {
        return value1 * value2;
    }

    static int div(final int value1, final int value2) {
        return value1 / value2;
    }

    public static void main(String[] args) throws InterruptedException {

        call(FI::add, 2, 3);
        call(FI::sub, 7, 4);
        call(FI::mul, 3, 3);
        call(FI::div, 8, 4);
    }
}