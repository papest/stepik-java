import java.util.Scanner;

public class CapitalLetters {
    public static void main(String[] args) {
        String message = readInput();
        int result = message.replaceAll("[^A-ZА-Я]", "").length();
        System.out.println(result);
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}