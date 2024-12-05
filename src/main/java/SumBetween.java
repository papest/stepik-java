import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;

public class SumBetween {
    public static void main(String[] args) {
        Triple<List<Integer>, Integer, Integer> input = readInput();
        List<Integer> data = input.getFirst();
        Integer start = input.getSecond();
        int end = input.getThird();
        int startIndex = data.indexOf(start);
        int endIndex = data.lastIndexOf(end);
        int result = 0;
        for (int i = startIndex; i <= endIndex && i >= 0; i++) {
            result += data.get(i);
        }

        System.out.println(result);
    }

    public static Triple<List<Integer>, Integer, Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] values = input.split(" \\| ");

        List<Integer> data = new Gson().fromJson(values[0], new TypeToken<List<Integer>>() {
        }.getType());
        int start = Integer.parseInt(values[1]);
        int end = Integer.parseInt(values[2]);

        return new Triple<>(data, start, end);
    }
}

