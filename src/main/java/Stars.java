import java.util.Arrays;
import java.util.Scanner;

public class Stars {
    public static void main(String[] args) {
        int stars = readInput();
        char[] chars = new char[stars];
        Arrays.fill(chars, '★');
        String result = new String(chars);
        System.out.println(result);
    }

    public static int readInput() {
        int stars = 0;

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            stars = Integer.parseInt(scanner.nextLine());
        }
        scanner.close();

        return stars;
    }
}

