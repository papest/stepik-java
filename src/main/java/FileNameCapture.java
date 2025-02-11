
import java.nio.file.*;
import java.util.Scanner;

public class FileNameCapture {
    public static void main(String[] args) {
        String path = readInput();
        String result = getFilename(path);
        System.out.println(result);
    }

    public static String getFilename(String path) {
        return Path.of(path).getFileName().toString().split("\\.")[0];
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}
