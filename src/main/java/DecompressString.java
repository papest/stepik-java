import java.util.*;
import java.util.stream.Stream;

public class DecompressString {
    public static void main(String[] args) {
        String message = readInput();
        ArrayList<String> result = new ArrayList<>();
        Scanner scanner = new Scanner(message);

        scanner
                .findAll("([A-Za-z]+)([1-9]+)")
                .flatMap(matchResult -> Stream.generate(() -> matchResult.group(1)).limit(Integer.parseInt(matchResult.group(2))))
                .forEach(result::add);

        System.out.println(String.join(", ", result));
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}