import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiggerSizeList {
    public static void main(String[] args) {
        Triple<Integer, String, List<Integer>> input = readInput();
        int size = input.getFirst();
        String position = input.getSecond();
        List<Integer> data = input.getThird();
        String result = fillArray(size, position, data);
        System.out.println(result);
    }

    public static String fillArray(int size, String position, List<Integer> data) {
        if (!(position.equals("left") || position.equals("right"))) return "Неверная позиция";
        if (size < data.size()) return "Неверный размер";

        Stream<Integer> addStream = Stream.generate(() -> 0).limit(size - data.size());
        return (!position.equals("left") ? Stream.concat(data.stream(), addStream) : Stream.concat(addStream, data.stream()))
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

    }

    public static Triple<Integer, String, List<Integer>> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] values = input.split(" \\| ");
        int size = Integer.parseInt(values[0]);
        String position = values[1];
        List<Integer> data = new Gson().fromJson(values[2], new com.google.gson.reflect.TypeToken<List<Integer>>() {
        }.getType());

        return new Triple<>(size, position, data);
    }
}

class Triple<F, S, T> {
    private final F first;
    private final S second;
    private final T third;

    public Triple(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public T getThird() {
        return third;
    }
}
