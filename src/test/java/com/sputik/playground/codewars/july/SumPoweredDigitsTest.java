package com.sputik.playground.codewars.july;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The number 89 is the first integer with more than one digit that fulfills the property
 * partially introduced in the title of this kata. What's the use of saying "Eureka"? Because this sum gives the same number.
 * <p>
 * In effect: 89 = 8^1 + 9^2
 * <p>
 * The next number in having this property is 135.
 * <p>
 * See this property again: 135 = 1^1 + 3^2 + 5^3
 * <p>
 * We need a function to collect these numbers, that may receive two integers a, b that defines the range [a, b] (inclusive)
 * and outputs a list of the sorted numbers in the range that fulfills the property described above.
 */
class SumPoweredDigitsTest {

    @Test
    void shouldReturnEmptyList() {
        assertEquals(
                List.of(),
                sumDigPow(90, 100)
        );


    }

    @Test
    void shouldReturnSimpleNumbersAnd89() {
        assertEquals(
                List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 89L),
                sumDigPow(1, 101)
        );
    }

    @Test
    void testBestSolutionFromCodewars() {
        assertEquals(
                List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 89L),
                sumDigPowBest(1, 121)
        );
    }

    private List<Long> sumDigPow(long a, long b) {
        ArrayList<Long> nums = new ArrayList<>();

        for (long i = a; i <= b; i++) {
            if (i < 10) {
                nums.add(i);
            } else {
                String num = String.valueOf(i);
                int pawned = IntStream.rangeClosed(1, num.length())
                        .map(j -> (int) Math.pow(
                                Character.getNumericValue(num.charAt(j - 1)),
                                j
                        )).sum();

                if (pawned == i) nums.add(i);
            }
        }

        return nums;
    }

    private List<Long> sumDigPowBest(long a, long b) {
        return LongStream.rangeClosed(a, b)
                .filter(this::isValid)
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean isValid(long n) {
        String s = String.valueOf(n);
        return IntStream.range(0, s.length())
                .mapToDouble(i -> Math.pow(
                        Character.getNumericValue(s.charAt(i)),
                        i + 1
                )).sum() == n;
    }
}
