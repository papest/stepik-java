import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.IntStream;

public class ShiftMatrix {

    public static void main(String[] args) {
        Pair<List<List<Integer>>, Integer> input = readInput();
        List<List<Integer>> data = input.getFirst();
        int shift = input.getSecond();
        List<List<Integer>> result;

        result = cyclicLeftShift(data, shift);

        System.out.println(new Gson().toJson(result));
    }

    public static List<List<Integer>> cyclicLeftShift(List<List<Integer>> data, int shift) {
        int width = data.get(0).size();
        int height = data.size();
        int commonSize = height * width;
        int sh = shift % commonSize < 0 ? commonSize + shift % commonSize : shift % commonSize;

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            result.add(new ArrayList<>());
        }

        IntStream.range(0, commonSize)
                .forEach(i -> result.get(i / width)
                        .add(i % width, data.get((i + sh) % commonSize / width).get((i + sh) % width)));

        return result;
    }

    public static Pair<List<List<Integer>>, Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(" \\| ");
        String dataString = parts[0].trim();
        int shift = Integer.parseInt(parts[1].trim());
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<ArrayList<Integer>>>() {
        }.getType();
        List<List<Integer>> data = gson.fromJson(dataString, listType);
        return new Pair<>(data, shift);
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
