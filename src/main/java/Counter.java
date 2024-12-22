import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class Counter {
    public static void main(String[] args) {
        List<Double> data = readInput();
        String result = countNumbers(data);
        System.out.println(result);
    }

    public static String countNumbers(List<Double> data) {
        Map<Integer, Integer> result = data
                .stream()
                .map(Double::intValue)
                .collect(Collectors.toMap(i -> i, i -> 1, Integer::sum));
        long size = result.size();
        long uniqueCount = result.entrySet().stream().filter(entry -> entry.getValue() == 1).count();
        long duplicateCount = size - uniqueCount;
        long zeroCount = result.get(0);
        long evenCount = result
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey() % 2 == 0)
                .mapToInt(Map.Entry::getValue)
                .sum() - zeroCount;
        long oddCount = result
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey() % 2 != 0)
                .mapToInt(Map.Entry::getValue)
                .sum();

        return String.format("%s, %s, %s, %s, %s", uniqueCount, duplicateCount, zeroCount, evenCount, oddCount);

    }

    public static List<Double> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Gson gson = new Gson();
        List<Double> data = gson.fromJson(input, List.class);
        return data;
    }
}