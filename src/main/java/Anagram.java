import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        Pair<String, String> inputs = readInput();
        String message1 = inputs.getFirst();
        String message2 = inputs.getSecond();
        ArrayList<Integer> list1 = (ArrayList<Integer>) message1
                .toLowerCase()
                .replaceAll("[^a-zа-я]", "")
                .chars()
                .boxed()
                .collect(Collectors.toList());
        list1
                .removeAll(message2
                        .toLowerCase()
                        .chars()
                        .boxed()
                        .collect(Collectors.toList()));
        boolean result = list1.isEmpty();


        System.out.println(result);
    }

    public static Pair<String, String> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] parts = input.split(" \\| ");
        return new Pair<>(parts[0], parts[1]);
    }
}


