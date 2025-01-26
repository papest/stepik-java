import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HiddenWords {
    public static void main(String[] args) {
        String message = readInput();
        String result = findHiddenWords(message);
        System.out.println(result);
    }

    public static String findHiddenWords(String message) {
        return Arrays.stream(message
                        .replaceAll("[fogFOG]", "")
                        .split(""))
                .dropWhile(st -> st.isEmpty() || Character.isLowerCase(st.codePointAt(0)))
                .collect(Collectors.joining("_"));

    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}
