package hh;

public class Task2 {
    public String processLine(String line) {
        return "LOG" + new StringBuilder(line)
                .reverse()
                .toString()
                .replaceAll("[1-9]", "")
                .replaceAll(" ", "_");

    }

    public static void main(String[] args) {
        System.out.println(new Task2().processLine("Hello, World 123!"));
    }
}
