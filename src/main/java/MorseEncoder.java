import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MorseEncoder {
    static Map<String, String> morse = morse();

    public static void main(String[] args) {

        String message = readInput();
        String result = encode(message);
        System.out.println(result);
    }

    public static String encode(String message) {

        return Arrays.stream(message.split(""))
                .map(morse::get)
                .collect(Collectors.joining(" "));
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