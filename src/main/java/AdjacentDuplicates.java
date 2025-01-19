
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdjacentDuplicates {
    public static void main(String[] args) {
        String message = readInput();
        boolean result = hasAdjacentDuplicates(message);
        System.out.println(result);
    }

    public static boolean hasAdjacentDuplicates(String message) {
        Pattern pattern = Pattern.compile("(.)\\1");
        Matcher matcher = pattern.matcher(message);
        return matcher.find();
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}