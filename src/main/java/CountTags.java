import com.google.gson.*;

import java.util.*;
import java.util.stream.Collectors;

public class CountTags {
    public static void main(String[] args) {
        List<String> tags = readInput();
        String result = tags
                .stream()
                .distinct()
                .map(s -> String.format("%s: %s", s, Collections.frequency(tags, s)))
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }

    public static List<String> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input;
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
            Gson gson = new Gson();
            String[] dataArray = gson.fromJson(input, String[].class);
            return Arrays.asList(dataArray);
        }
        scanner.close();
        return null;
    }
}