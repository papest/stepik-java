import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;

public class ConsecutiveZeros {
    public static void main(String[] args) {
        List<Integer> data = readInput();
        boolean result = hasTwoConsecutiveZeros(data);
        System.out.println(result);
    }

    public static boolean hasTwoConsecutiveZeros(List<Integer> data) {
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i - 1) == 0 && data.get(i) == 0) {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Gson().fromJson(input, new TypeToken<List<Integer>>() {
        }.getType());
    }
}