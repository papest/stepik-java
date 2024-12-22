import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class MaxAscSequence {
    public static void main(String[] args) {
        List<Integer> data = readInput();
        int result = findLongestSeries(data);
        System.out.println(result);
    }

    public static int findLongestSeries(List<Integer> data) {
        int count = 0;
        int max = 0;
        int curr = 0;
        for (int el : data) {
            if (count == 0 || el > curr) {
                curr = el;
                count++;
                max = Math.max(count, max);
            } else {
                count = 1;
                curr = el;
            }
        }
        return max;
    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Integer>>() {
        }.getType();
        return gson.fromJson(input, listType);
    }
}
