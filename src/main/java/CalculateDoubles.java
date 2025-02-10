import java.util.Scanner;
import java.util.stream.DoubleStream;

class CalculateDouble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] d = DoubleStream
                .generate(scanner::nextDouble)
                .limit(4)
                .toArray();
        System.out.println(d[0] * 10.5 + d[1] * 4.4 + (d[2] + d[3]) / 2.2);
    }
}