import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManipulatingCollections {
    public static void main(String[] args) {
        Pair<String, String> inputs = readInput();
        String message1 = inputs.getFirst();
        String message2 = inputs.getSecond();
        ArrayList<String> list1 = new ArrayList<>(List.of(message1.split(" ")));
        ArrayList<String> list2 = new ArrayList<>(List.of(message2.split(" ")));
        String result = String.join(" | ", list1.stream().filter(list2::contains).collect(Collectors.joining(", ")), list1.stream().filter(s -> !list1.contains(s) || !list2.contains(s)).collect(Collectors.joining(", ")),
                Stream.of(list1.stream(), list2.stream()).flatMap(s -> s).filter(s -> !list1.contains(s) || !list2.contains(s)).collect(Collectors.joining(", ")));


        System.out.println(result);
    }

    public static Pair<String, String> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] parts = input.split(" \\| ");
        return new Pair<>(parts[0], parts[1]);
    }
}

