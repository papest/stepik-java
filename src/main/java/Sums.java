import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sums {

    public static void main(String[] args) {
        Pair<Integer, List<Integer>> input = readInput();
        int k = input.getFirst();
        List<Integer> data = input.getSecond();
        String result = findPairs(k, data);

        System.out.println(result);
    }

    public static String findPairs(int k, List<Integer> data) {

        String result = IntStream.range(0, data.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, data.size()).filter(j -> data.get(i) + data.get(j) == k)
                        .mapToObj(j -> String.format("(%s + %s)", data.get(i), data.get(j)))
                )
                .collect(Collectors.joining(""));
        result = result.isEmpty() ? "()" : result;
        return result;

    }

    public static Pair<Integer, List<Integer>> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(" \\| ");
        int k = Integer.parseInt(parts[0].trim());
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Integer>>() {
        }.getType();
        List<Integer> data = gson.fromJson(parts[1], listType);
        return new Pair<>(k, data);
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