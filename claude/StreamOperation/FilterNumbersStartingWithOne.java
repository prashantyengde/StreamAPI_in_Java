package claude.StreamOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNumbersStartingWithOne {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 8, 49, 25, 98, 32);

        List<Integer> result = numbers.stream()
                .filter(n -> String.valueOf(n).startsWith("1"))
                .collect(Collectors.toList());

        System.out.println("Numbers starting with 1: " + result);
    }
}