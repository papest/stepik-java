import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeriesCount {
    public static void main(String[] args) {
        List<Integer> data = readInput();
        int result = findSeriesCount(data);
        System.out.println(result);
    }

    public static int findSeriesCount(List<Integer> data) {
        boolean newSeries = true;
        int count = 0;
        int curr = 0;
        for (int el : data) {
            if (!newSeries && curr == el) {
                count++;

            } else {
                curr = el;
                newSeries = false;
            }
        }
        return count;
    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Integer>>() {}.getType();
        return gson.fromJson(input, listType);
    }
}