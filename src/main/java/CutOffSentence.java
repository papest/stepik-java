
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CutOffSentence {
    public static void main(String[] args) {
        Pair<Integer, String> input = readInput();
        int wordsCount = input.getFirst();
        String message = input.getSecond();
        String result = truncateWords(message, wordsCount);

        System.out.println(result);
    }

    public static String truncateWords(String message, int wordsCount) {

        int size = message.split("\\s").length;
        if (wordsCount < size) {
            Pattern pattern = Pattern.compile("\\s");
            Matcher matcher = pattern.matcher(message);
            for (int i = 0; i != wordsCount; i++) {
                matcher.find();
            }
            return message.substring(0, matcher.start()).concat("...");
        } else {
            return message;
        }
    }

    public static Pair<Integer, String> readInput() {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] parts = inputLine.split(" \\| ");
        int wordsCount = Integer.parseInt(parts[0].trim());
        String message = parts[1].trim();
        return new Pair<>(wordsCount, message);
    }
}
