public class AppArguments {
    public static void main(String[] args) {
        int result;

        switch (args[1]) {
            case "+":
                result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
                break;
            case "-":
                result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
                break;
            case "*":
                result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
                break;
            case "/":
                result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
                break;
            default:
                System.err.println("Illegal sign");
                return;
        }
        System.err.println(result);
    }
}

