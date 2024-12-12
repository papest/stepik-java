import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;

public class Balance {
    public static void main(String[] args) {
        List<Integer> data = readInput();
        String result = balance(data);
        System.out.println(result);
    }

    public static String balance(List<Integer> data) {
        int median = data.size() / 2;
        int leftSum = data.subList(0, median).stream().reduce(0, Integer::sum);
        int rightSum = data.subList(median, data.size()).stream().reduce(0, Integer::sum);
        return leftSum > rightSum ? "Левая сторона тяжелее" : leftSum < rightSum ? " Правая сторона тяжелее" :
                        "Обе стороны сбалансированы";
    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Gson().fromJson(input, new TypeToken<List<Integer>>() {
        }.getType());
    }
}
