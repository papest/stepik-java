
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        String message = readInput();
        boolean result = new StringBuilder(message).reverse().toString().equals(message);
        System.out.println(result);
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}
