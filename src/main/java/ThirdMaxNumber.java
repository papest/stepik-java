import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class ThirdMaxNumber {
    public static void main(String[] args) {
        List<Integer> nums = readInput();
        int result;
        nums = nums.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        result = nums.size() < 3 ? nums.get(0) : nums.get(2);
        System.out.println(result);
    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Type listType = new TypeToken<ArrayList<Integer>>() {
        }.getType();
        return new Gson().fromJson(input, listType);
    }
}