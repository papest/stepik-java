
import com.google.gson.Gson;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnotherDiagonalList {

    public static void main(String[] args) {
        int n = readInput();
        List<List<Integer>> result = fillDiagonalList(n);

        System.out.println(new Gson().toJson(result));
    }

    public static List<List<Integer>> fillDiagonalList(int n) {
        return IntStream
                .range(0, n)
                .mapToObj(j -> IntStream.range(0, n).map(i -> j + i - n + 1 < 0 ? 0 : j + i - n + 1 == 0 ? 1 : 2)
                        .boxed()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public static int readInput() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine().trim());
    }
}