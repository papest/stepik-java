import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CapitalLetter {
    public static void main(String[] args) {
        String message = readInput();

        String result = Arrays.stream(message.split("\\b")).map(s -> s.isBlank() ? s :
                        s.replaceFirst(s.substring(0, 1), s.substring(0, 1).toUpperCase()))
                .collect(Collectors.joining());

        System.out.println(result);
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}