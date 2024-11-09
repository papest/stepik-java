import java.util.Map;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;

public class Op {

    public static void main(String[] args) {
        int x, y;
        String op;
        int result;
        Map<String, IntBinaryOperator> map = Map.of("+", Integer::sum, "-", (a, b) -> a - b, "", (a, b) -> 0);


        String[] inputValues = readInput();
        x = Integer.parseInt(inputValues[0]);
        op = inputValues[1];
        y = Integer.parseInt(inputValues[2]);
        result = map.get(op).applyAsInt(x, y);

        System.out.println(result);
    }

    public static String[] readInput() {
        String[] inputValues = new String[3];

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            inputValues = input.split(" ");
        }
        scanner.close();

        return inputValues;
    }
}