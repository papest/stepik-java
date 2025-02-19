
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TokenLength {
    public static void main(String[] args) {
        String message = readInput();
        String result = lettersCount(message);
        System.out.println(result);
    }

    public static String lettersCount(String message) {
        Scanner scanner = new Scanner(message);
        Pattern pattern = Pattern.compile("\\[[^\\[]*]");
        return scanner.findAll(pattern)
                .mapToInt(matchResult -> matchResult.end() - matchResult.start() - 2)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}