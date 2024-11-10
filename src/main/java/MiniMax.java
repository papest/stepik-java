import java.util.Arrays;
import java.util.Scanner;

public class MiniMax {
    public static void main(String[] args) {
        int x1, x2;
        String result;

        int[] inputValues = Arrays.stream(readInput()).sorted().toArray();
        x1 = inputValues[0];
        x2 = inputValues[2];
        result = String.format("минимальное: %s, максимальное: %s", x1, x2);
        System.out.println(result);
    }

    public static int[] readInput() {
        int[] inputValues = new int[3];

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] values = input.split(" ");
            for (int i = 0; i < 3; i++) {
                inputValues[i] = Integer.parseInt(values[i]);
            }
        }
        scanner.close();

        return inputValues;
    }
}

