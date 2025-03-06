import java.util.Scanner;

public class HammingDistance {
    public static void main(String[] args) {
        Pair<String, String> inputs = readInput();
        String search = inputs.getFirst();
        String message = inputs.getSecond();
        int size = message.length();
        int result = -1;
        if (size == search.length()) {
            result++;
            for (int i = 0; i < size; i++) {
                if (message.charAt(i) != search.charAt(i)) result++;
            }
        }


        System.out.println(result);
    }

    public static Pair<String, String> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] parts = input.split(" \\| ");
        return new Pair<>(parts[0], parts[1]);
    }
}
