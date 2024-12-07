import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;

public class FirstNegative {
    public static void main(String[] args) {
        List<Integer> data = readInput();
        Integer result = findFirstNegative(data);
        System.out.println(result != null ? result : 0);
    }

    public static Integer findFirstNegative(List<Integer> data) {
        return data.stream().filter(i -> i < 0).findFirst().orElse(0);
    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Gson().fromJson(input, new TypeToken<List<Integer>>() {
        }.getType());
    }
}