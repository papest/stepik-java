import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;

public class PerimeterSum {
    public static void main(String[] args) {
        List<List<Integer>> grid = readInput();
        int result;
        result = grid.get(0).stream().reduce(0, Integer::sum)
                + grid.get(grid.size() - 1).stream().reduce(0, Integer::sum);
        result += grid
                .stream()
                .mapToInt(list -> list.get(0) + list.get(list.size() - 1))
                .sum();

        System.out.println(result);
    }

    public static List<List<Integer>> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return new Gson().fromJson(input, new TypeToken<List<List<Integer>>>() {
        }.getType());
    }
}