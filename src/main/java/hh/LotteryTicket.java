package hh;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class LotteryTicket {

    public String countDigits(String digits) {
        Map<Integer, Integer> map = Arrays.stream(digits.split(""))
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toMap(k -> k, k -> 1, Integer::sum));
        String result = map
                .entrySet()
                .stream()
                .map(entry -> String.format("%s:%s", entry.getKey(), entry.getValue() + 1))
                .collect(Collectors.joining(", "));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LotteryTicket().countDigits("3435001"));
    }
}