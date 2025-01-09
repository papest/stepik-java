
import java.util.Scanner;

public class LetterCase {
    public static void main(String[] args) {
        String message = readInput();
        StringBuilder newStr = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                newStr.append(Character.toUpperCase(ch));
            } else {
                newStr.append(Character.toLowerCase(ch));
            }
        }

        String result = newStr.toString();
        System.out.println(result);
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}