import java.util.Scanner;

public class ClearString {
    public static void main(String[] args) {
        String message = readInput();
        String result = cleanStr(message);
        System.out.println(result);
    }

    public static String cleanStr(String message) {
        int size;
        do {
            size = message.length();
            message = message.replaceAll("\\(лишнее\\)", "");
        } while (size != message.length());
        return message.replaceAll("(\\(\\))+", "");
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}