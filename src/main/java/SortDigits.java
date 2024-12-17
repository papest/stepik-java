import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;


public class SortDigits {
    public static void main(String[] args) {
        Pair<List<Integer>, String> input = readInput();
        List<Integer> data = input.getFirst();
        String order = input.getSecond();
        List<Integer> result = customSort(data, order);
        System.out.println(new Gson().toJson(result));
    }

    public static List<Integer> customSort(List<Integer> data, String order) {

        return data
                .stream()
                .map(i -> Integer.parseInt(Arrays.stream(i.toString()
                                .split(""))
                        .map(Integer::valueOf)
                        .sorted("ASC".equals(order) ? Comparator.naturalOrder() : Comparator.reverseOrder())
                        .map(String::valueOf)
                        .collect(Collectors.joining()))
                )
                .collect(Collectors.toList());

    }

    public static Pair<List<Integer>, String> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(" \\| ");
        Type listType = new TypeToken<ArrayList<Integer>>() {
        }.getType();
        List<Integer> data = new Gson().fromJson(parts[0], listType);
        String order = parts[1].trim();
        return new Pair<>(data, order);
    }

    static class Pair<A, B> {
        private final A first;
        private final B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }
    }
}