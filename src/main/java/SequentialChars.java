import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SequentialChars {
    public static void main(String[] args) {
        String message = readInput();
        int size = message.length() - 1;
        String result;
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            String s = message.substring(i, i + 2);
            map.compute(s, (k, v) -> map.containsKey(k) ? v + 1 : 1);
        }

        result = map.entrySet()
                .stream()
                .map(entry -> String.join(":", entry.getKey(), entry.getValue().toString()))
                .collect(Collectors.joining(", "));


        System.out.println(result);
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}
