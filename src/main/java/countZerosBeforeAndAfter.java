import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;

public class countZerosBeforeAndAfter {
    public static void main(String[] args) {
        List<Integer> data = readInput();
        String result = countZerosBeforeAndAfter(data);
        System.out.println(result);
    }

    public static String countZerosBeforeAndAfter(List<Integer> data) {
        long count1 = data.stream().takeWhile(i -> i != 1).count();
        long count2 = data.size() - 1 - count1;
        return String.format("Количество нулей перед единицей: %s, Количество нулей после единицы: %s", count1, count2);
    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Gson().fromJson(input, new TypeToken<List<Integer>>() {
        }.getType());
    }
}