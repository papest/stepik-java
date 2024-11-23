import com.google.gson.Gson;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;

public class ReverseList {
    public static void main(String[] args) {
        List<String> data = readInput();
        Collections.reverse(data);
        String result = String.join(", ", data);

        System.out.println(result);
    }

    public static List<String> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input;
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
            Gson gson = new Gson();
            String[] dataArray = gson.fromJson(input, String[].class);
            return Arrays.asList(dataArray);
        }
        scanner.close();
        return null;
    }
}