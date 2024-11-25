import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class EvenOdd {
    public static void main(String[] args) {
        List<Integer> data = readInput();
        String result;

        result = findEvenOddNumbers(data);

        System.out.println(result);
    }

    public static String findEvenOddNumbers(List<Integer> data) {
        return data
                .stream()
                .sorted()
                .collect(Collectors.partitioningBy(i -> i % 2 != 0))
                .values()
                .stream()
                .map(i -> i.stream().map(String::valueOf)
                        .collect(Collectors.joining(", ", "(", ")")))
                .collect(Collectors.joining(" "));

    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Integer>>() {
        }.getType();
        return gson.fromJson(input, listType);
    }
}