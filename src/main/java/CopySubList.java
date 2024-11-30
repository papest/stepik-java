import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class CopySubList {
    public static void main(String[] args) {
        Pair<Integer, List<Integer>> input = readInput();
        int n = input.getFirst();
        List<Integer> data = input.getSecond();
        String result = copyItems(n, data);
        System.out.println(result);
    }

    public static String copyItems(int n, List<Integer> items) {
        items.addAll(items.subList(0, n));
        return items
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

    }

    public static Pair<Integer, List<Integer>> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] values = input.split(" \\| ");
        int n = Integer.parseInt(values[0]);
        List<Integer> data = new Gson().fromJson(values[1], new com.google.gson.reflect.TypeToken<List<Integer>>() {
        }.getType());

        return new Pair<>(n, data);
    }
}

