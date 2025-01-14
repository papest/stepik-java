
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Chars {
    public static void main(String[] args) {
        String city = readInput();
        String result = city.
                chars()
                .mapToObj(i -> Character.toLowerCase((char) i))
                .collect(Collectors.toMap(Function.identity(), i -> "*", String::concat, LinkedHashMap::new
                ))
                .entrySet()
                .stream()
                .map(entry -> String.join(":", entry.getKey().toString(), entry.getValue()))
                .collect(Collectors.joining(","));

        System.out.println(result);
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}