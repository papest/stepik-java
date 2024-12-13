import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateList {
    public static void main(String[] args) {
        int length = readInput();
        List<Integer> result = generateArray(length);
        System.out.println(new Gson().toJson(result));
    }

    public static List<Integer> generateArray(int length) {
        List<Integer> result = IntStream
                .range(1, length + 1)
                .map(i -> i * 3)
                .boxed()
                .collect(Collectors.toList());
        Collections.reverse(result);
        return result;
    }

    public static int readInput() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}