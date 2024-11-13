import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfOddNumbers {
    public static void main(String[] args) {
        int n = readInput();
        String result;
        int lastOdd = n % 2 == 1 ? n : n - 1;
        BigInteger res = BigInteger.valueOf(n % 2 == 1 ? n : n - 1);
        for (int i = lastOdd - 2; i > 1; i -= 2) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        result = res.toString();

        System.out.println(result);

    }

    public static int readInput() {
        int n = 0;

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            n = Integer.parseInt(scanner.nextLine());
        }
        scanner.close();

        return n;
    }
}