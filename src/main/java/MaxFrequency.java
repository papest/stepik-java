import com.google.gson.Gson;
import java.util.*;
import java.util.stream.Collectors;

public class MaxFrequency {
    public static void main(String[] args) {
        List<Integer> data = readInput();
        int result = findMostFrequentElement(data);
        System.out.println(result);
    }

    public static int findMostFrequentElement(List<Integer> data) {
        return data
                .stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .orElse(Map.entry(0,0L))
                .getKey();
    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Gson gson = new Gson();
        Integer[] dataArray = gson.fromJson(input, Integer[].class);
        return Arrays.asList(dataArray);
    }
}