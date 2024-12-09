import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;
import java.util.stream.Collectors;

public class AllPng {
    public static void main(String[] args) {
        List<String> data = readInput();
        List<String> result = findPNGFiles(data);
        System.out.println(new Gson().toJson(result));
    }

    public static List<String> findPNGFiles(List<String> files) {
        return files
                .stream()
                .filter(i -> i.matches(".*\\.png"))
                .collect(Collectors.toList());
    }

    public static List<String> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Gson().fromJson(input, new TypeToken<List<String>>() {
        }.getType());
    }
}