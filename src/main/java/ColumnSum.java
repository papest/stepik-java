import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ColumnSum {
    public static void main(String[] args) {
        List<List<Integer>> data = readInput();
        List<Integer> result = columnSum(data);
        System.out.println(new Gson().toJson(result));
    }

    public static List<Integer> columnSum(List<List<Integer>> data) {
        if (data.isEmpty() || data.get(0).isEmpty()) return new ArrayList<>();
        return IntStream.range(0, data.get(0).size())
                .map(i -> data.stream().mapToInt(d -> d.get(i)).sum())
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Gson().fromJson(input, new TypeToken<List<List<Integer>>>() {
        }.getType());
    }
}
