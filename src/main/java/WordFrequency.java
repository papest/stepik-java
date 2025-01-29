import java.util.*;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {
        Pair<String, String> inputs = readInput();
        String message1 = inputs.getFirst();
        String message2 = inputs.getSecond();
        List<String> list = List.of(message1.split(" "));

        Map<Object, Long> map = Arrays
                .stream(message2.split(" "))
                .filter(list::contains)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        String result = list.stream()
                .map(s -> String.join(": ", s, String.valueOf(map.containsKey(s) ? map.get(s) : 0)))
                .collect(Collectors.joining(", "));


        System.out.println(result);
    }

    public static Pair<String, String> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] parts = input.split(" \\| ");
        return new Pair<>(parts[0], parts[1]);
    }
}

