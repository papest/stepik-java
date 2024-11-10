import java.util.Scanner;


public class MobilePosition {

    final int MAX_Y = 100;
    final int MAX_X = 100;
    private int x;
    private int y;

    private final Field field = new Field();

    private Direction direction;

    public MobilePosition(int x, int y, Direction direction) {
        this.direction = direction;
        this.x = inFieldX(x + direction.dx, field);
        this.y = inFieldY(y + direction.dy, field);
    }

    private int inFieldY(int y, Field field) {
        int max = field.getMaxY();
        return Math.max(Math.min(max, y), 0);
    }

    private int inFieldX(int x, Field field) {
        int max = field.getMaxX();
        return Math.max(Math.min(x, max), 0);
    }

    public static void main(String[] args) {
        int x, y;
        String direction, result;

        String[] inputValues = readInput();
        x = Integer.parseInt(inputValues[0]);
        y = Integer.parseInt(inputValues[1]);
        direction = inputValues[2];
        result = new MobilePosition(x, y, Direction.valueOf(direction)).toString();
        System.out.println(result);
    }

    public static String[] readInput() {
        String[] inputValues = new String[3];

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] values = input.split(" ");
            for (int i = 0; i < 3; i++) {
                inputValues[i] = values[i];
            }
        }
        scanner.close();

        return inputValues;
    }



    @Override
    public String toString() {
        return String.format("x: %s, y: %s, direction: %s\n", x, y, direction);
    }

    private enum Direction {
        up(0, -1),
        down(0, 1),
        left(-1, 0),
        right(1, 0);

        private final int dx;
        private final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }


    }

    private class Field {

        public int getMaxX() {
            return MAX_X;
        }

        public int getMaxY() {
            return MAX_Y;
        }

    }
}
