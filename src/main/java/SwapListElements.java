import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class SwapListElements {

    public static void main(String[] args) {
        List<Integer> data = readInput();
        List<Integer> result = swapElements(data);

        System.out.println(new Gson().toJson(result));
    }

    public static List<Integer> swapElements(List<Integer> data) {
        Integer max = data.stream().filter(i -> i % 2 == 0).max(Comparator.naturalOrder()).orElse(null);
        Integer min = data.stream().filter(i -> i % 2 != 0).min(Comparator.naturalOrder()).orElse(null);
        if (max == null || min == null) {
            Collections.fill(data, 0);
        } else {
            int indexMax = data.indexOf(max);
            int indexMin = data.indexOf(min);
            data.set(indexMax, min);
            data.set(indexMin, max);
        }
        return data;
    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Integer>>() {
        }.getType();
        return gson.fromJson(input, listType);
    }
}
