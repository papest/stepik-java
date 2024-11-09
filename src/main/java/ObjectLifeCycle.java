public class ObjectLifeCycle {
    public ObjectLifeCycle() {
        System.err.print('1');
    }

    public void print() {
        System.err.print('2');
    }

    @Override
    public void finalize() {
        System.err.print('3');
    }

    {
        System.err.print('4');
    }

    static {
        System.err.print('5');
    }


    public static void main(String[] args) {
        System.err.print('6');
        new ObjectLifeCycle().print();
        Runtime.getRuntime().runFinalization();
    }
}