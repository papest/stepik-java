import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;
import java.util.stream.Collectors;

public class RowSum {
    public static void main(String[] args) {
        List<List<Integer>> data = readInput();
        List<Integer> result = rowSum(data);
        System.out.println(new Gson().toJson(result));
    }

    public static List<Integer> rowSum(List<List<Integer>> data) {
        return data
                .stream()
                .map(list -> list.stream().reduce(0, Integer::sum))
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Gson().fromJson(input, new TypeToken<List<List<Integer>>>() {
        }.getType());
    }
}