import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;

public class CompressStringList {
    public static void main(String[] args) {
        List<String> data = readInput();
        StringBuilder result = new StringBuilder();
        String current = null;
        int count = 0;
        for (String curr : data) {
            if (curr.equals(current)) {
                count++;
            } else if (count == 0) {
                current = curr;
                count++;
                result.append(curr);
            } else {
                current = curr;
                result.append(count);
                result.append(curr);
                count = 1;
            }

        }
        if (count != 0) result.append(count);

        System.out.println(result);
    }

    public static List<String> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Gson().fromJson(input, new TypeToken<List<String>>() {
        }.getType());
    }
}
