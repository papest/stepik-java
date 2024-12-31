import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class Counts {

    public static void main(String[] args) {
        List<List<Integer>> grid = readInput();
        String result = countTiles(grid);

        System.out.println(result);
    }

    public static String countTiles(List<List<Integer>> grid) {
        int water = (int) grid.stream().flatMap(List::stream).filter(i -> i == 0).count();
        int earth = (int) grid.stream().flatMap(List::stream).filter(i -> i == 1).count();
        int ships = (int) grid.stream().flatMap(List::stream).filter(i -> i == 2).count();
        return String.format("блоков воды: %s, блоков земли: %s, блоков кораблей: %s", water, earth, ships);
    }

    public static List<List<Integer>> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<List<Integer>>>() {
        }.getType();
        return gson.fromJson(input, listType);
    }
}