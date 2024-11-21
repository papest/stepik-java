import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Scanner;

public class EvenList {
    public static void main(String[] args) {
        List<Integer> data = readInput();
        boolean result;
        result = data.size() == data.stream().filter(num -> num % 2 == 0).count();
        System.out.println(result);
    }

    public static List<Integer> readInput() {
        List<Integer> data = null;

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            Gson gson = new Gson();
            data = gson.fromJson(input, new TypeToken<List<Integer>>() {
            }.getType());
        }
        scanner.close();

        return data;
    }
}