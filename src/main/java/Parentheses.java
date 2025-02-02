import java.util.Scanner;

public class Parentheses {
    public static void main(String[] args) {
        String message = readInput();
        boolean result = message.replaceAll("[^(]", "").length() == message.replaceAll("[^)]", "").length() &&
                message.replaceAll("[^{]", "").length() == message.replaceAll("[^}]", "").length() &&
                message.replaceAll("[^\\[]", "").length() == message.replaceAll("[^]]", "").length();


        System.out.println(result);
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}