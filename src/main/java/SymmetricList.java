import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;
import java.util.stream.Collectors;

public class SymmetricList {
    public static void main(String[] args) {
        List<Integer> data = readInput();
        List<Integer> result = mirrorArray(data);
        System.out.println(convertToString(result));
    }

    public static List<Integer> mirrorArray(List<Integer> data) {
        ArrayList<Integer> sList = new ArrayList<>(data.subList(0, data.size() - 1));
        Collections.reverse(sList);
        data.addAll(sList);
        return data;
    }

    public static String convertToString(List<Integer> arr) {
        return arr.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> data = new Gson().fromJson(input, new TypeToken<List<Integer>>() {
        }.getType());
        return data;
    }
}