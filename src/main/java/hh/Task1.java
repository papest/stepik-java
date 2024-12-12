package hh;

import java.util.Scanner;

public class Task1 {
    public String calculate(String input) {
        Scanner scanner = new Scanner(input);
        String op = scanner.next();
        double x = 0.0;
        double sq;
        double per;
        if (scanner.hasNext()) x = scanner.nextDouble();

        if ("круг".equals(op)) {
            sq = Math.PI * x * x;
            per = 2.0 * Math.PI * x;

        } else {
            sq = x * x;
            per = 4.0 * x;
        }


        return String.format("%.2f %.2f", sq, per);
    }

    public static void main(String[] args) {
        System.out.println(new Task1().calculate("круг 3"));
    }
}
