import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MorseDecoder {
    static Map<String, String> morse = morse()
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

    public static void main(String[] args) {

        String message = readInput();
        String result = decode(message);
        System.out.println(result);
    }

    public static String decode(String message) {
        Pattern pattern = Pattern.compile(" ([^ ]+| )");
        return new Scanner(" " + message + " ")
                .findAll(pattern)
                .map(matchResult -> matchResult.group().substring(1))
                .map(morse::get)
                .collect(Collectors.joining());
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    public static Map<String, String> morse() {
        String morseMap = "{ 'A': '.-', 'B': '-...', 'C': '-.-.', 'D': '-..', 'E': '.', 'F': '..-.', 'G': '--.', 'H': '....'," +
                "    'I': '..', 'J': '.---', 'K': '-.-', 'L': '.-..', 'M': '--', 'N': '-.', 'O': '---', 'P': '.--.'," +
                "    'Q': '--.-', 'R': '.-.', 'S': '...', 'T': '-', 'U': '..-', 'V': '...-', 'W': '.--', 'X': '-..-'," +
                "    'Y': '-.--', 'Z': '--..', '0': '-----', '1': '.----', '2': '..---', '3': '...--', '4': '....-'," +
                "    '5': '.....', '6': '-....', '7': '--...', '8': '---..', '9': '----.', ' ': ' ' }";
        Scanner scanner = new Scanner(morseMap);
        String input = scanner.nextLine();
        return new Gson().fromJson(input, new TypeToken<Map<String, String>>() {
        }.getType());
    }
}