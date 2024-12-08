import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;
import java.util.stream.Collectors;

public class AboveAverage {
    public static void main(String[] args) {
        List<Integer> data = readInput();
        List<Integer> result = filterAboveAverage(data);
        System.out.println(new Gson().toJson(result));
    }

    public static List<Integer> filterAboveAverage(List<Integer> data) {
        double avg = data.stream().collect(Collectors.averagingInt(a -> a));
        return data.stream().filter(i -> Double.valueOf(i) > avg).collect(Collectors.toList());
    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Gson().fromJson(input, new TypeToken<List<Integer>>() {
        }.getType());
    }
}