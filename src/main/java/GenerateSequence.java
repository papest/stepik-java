import com.google.gson.Gson;

import java.util.*;
import java.util.stream.*;

public class GenerateSequence {
    public static void main(String[] args) {
        int length = readInput();
        List<Integer> result = generateArray(length);
        System.out.println(new Gson().toJson(result));
    }

    public static List<Integer> generateArray(int length) {
        return IntStream
                .concat(IntStream.range(0, length).map(i -> ++i), IntStream.range(0, length).map(i -> length - i))
                .boxed()
                .collect(Collectors.toList());

    }

    public static int readInput() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
