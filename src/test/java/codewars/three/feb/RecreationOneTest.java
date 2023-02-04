package codewars.three.feb;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RecreationOneTest {

    @Test
    void test1() {
        assertThat(listSquared(1, 250)).isEqualTo("[[1, 1], [42, 2500], [246, 84100]]");
    }

    private String listSquared(int m, int n) {

        var dic = new HashMap<Integer, Integer>();
        for (int i = m; i <= n; i++) {
            var squaredSum = sumSquareOfDivisors(i);
            if (Math.sqrt(squaredSum) % 1 == 0) dic.put(i, squaredSum);
        }

        return formatResult(dic);
    }

    private static int sumSquareOfDivisors(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> n % i == 0)
                .map(i -> i * i)
                .sum();
    }

    private static String formatResult(HashMap<Integer, Integer> dic) {
        return dic.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> String.format("[%s, %s]", e.getKey(), e.getValue()))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    @Test
    void test2() {
        assertThat(listSquared2(42, 251)).isEqualTo("[[42, 2500], [246, 84100]]");
    }

    private String listSquared2(int n, int m) {
        return IntStream.rangeClosed(n, m)
                .mapToObj(it -> {
                    var sum = sumSquareOfDivisors(it);
                    if (Math.sqrt(sum) % 1 == 0) {
                        return String.format("[%d, %d]", it, sum);
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", ", "[", "]"));
    }

}
