import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;
import java.util.stream.IntStream;

public class DiagonalsSum {
    public static void main(String[] args) {
        List<List<Integer>> grid = readInput();
        Integer result;
        int listSize = grid.get(0).size();
        int size = grid.size();
        if (listSize != size) {
            result = -1;
        } else {
            result = IntStream
                    .range(0, size).map(i -> grid.get(i).get(i) + grid.get(i).get(size - i - 1))
                    .boxed()
                    .reduce(0, Integer::sum);
        }

        System.out.println(result);
    }

    public static List<List<Integer>> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return new Gson().fromJson(input, new TypeToken<List<List<Integer>>>() {
        }.getType());
    }
}
