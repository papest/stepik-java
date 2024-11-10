import java.util.Scanner;

public class Role {
    public static void main(String[] args) {
        int role = readInput();
        String result = switch (role) {
            case 1 -> "admin";
            case 2 -> "moderator";
            case 3 -> "user";
            default -> "guest";
        };

        System.out.println(result);
    }

    public static int readInput() {
        int role = 0;

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            role = Integer.parseInt(scanner.nextLine());
        }
        scanner.close();

        return role;
    }
}
