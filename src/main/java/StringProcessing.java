import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringProcessing {
    public static void main(String[] args) {
        String message = readInput();
        String result = getTopHashtags(message);
        System.out.println(result);
    }

    public static String getTopHashtags(String message) {
        return Arrays
                .stream(message
                        .toLowerCase()
                        .split("[ ,.;!?:]+"))
                .filter(s -> s.length() > 4)
                .limit(5)
                .collect(Collectors.joining(" #", "#", ""));
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}