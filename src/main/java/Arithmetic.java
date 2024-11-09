public class Arithmetic {
    public static void main(String[] args) {
        int x = -1, y = x << 16;
        char result = (char) y;
        System.out.println("[" + y + "]");
        double x1 = 28, y1 = 5, z = 3.5;
        int result1 = (int) ((byte) (x1 / y1) * z);
        System.out.println(result1);
        x = 20;
        System.out.println(~x);
    }

}
