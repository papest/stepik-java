import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringProcessing2 {
    public static void main(String[] args) {
        String message = readInput();
        String result = getTopHashtags(message);
        System.out.println(result);
    }

    public static String getTopHashtags(String message) {
        List<String> list = Arrays
                .stream(message
                        .toLowerCase()
                        .split("[ ,.;!?:-]+"))
                .filter(s -> s.length() > 4)
                .collect(Collectors.toList());
        return list
                .subList(Math.max(list.size() - 5, 0), list.size())
                .stream().collect(Collectors.joining(" #", "#", ""));
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}