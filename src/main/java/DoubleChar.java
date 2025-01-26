import java.util.*;
import java.util.stream.Collectors;

public class DoubleChar {
    public static void main(String[] args) {
        String message = readInput();
        List<String> tmp = Arrays.stream(message.split("")).collect(Collectors.toList());
        String result = Arrays.stream(message.split(""))
                .filter(s -> !s.isBlank() && Collections.frequency(tmp, s) == 1)
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}
