import com.google.gson.Gson;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RectangleMatrix {

    public static void main(String[] args) {
        Pair<Integer, Integer> input = readInput();
        int width = input.getFirst();
        int height = input.getSecond();
        List<List<Integer>> result = createRectangle(width, height);

        System.out.println(new Gson().toJson(result));
    }

    public static List<List<Integer>> createRectangle(int width, int height) {
        return Stream
                .generate(() -> IntStream.generate(() -> 1).limit(width)
                        .boxed()
                        .collect(Collectors.toList()))
                .limit(height).collect(Collectors.toList());
    }

    public static Pair<Integer, Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(" \\| ");
        int width = Integer.parseInt(parts[0].trim());
        int height = Integer.parseInt(parts[1].trim());
        return new Pair<>(width, height);
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
