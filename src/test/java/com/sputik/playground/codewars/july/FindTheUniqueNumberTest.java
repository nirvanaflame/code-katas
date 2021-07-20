package com.sputik.playground.codewars.july;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * There is an array with some numbers. All numbers are equal except for one. Try to find it!
 * <p>
 * Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
 * Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
 * It’s guaranteed that array contains at least 3 numbers.
 */
public class FindTheUniqueNumberTest {

    @Test
    void shouldReturnUniqueNumber() {
        assertEquals(2.0, findUnique(new double[]{1, 1, 1, 2, 1, 1}));
    }

    @Test
    void shouldReturnUniqueNumberForManyDuplicated() {
        assertEquals(2.0, findUnique(new double[]{1, 1, 1, 2, 1, 1, 3, 3, 5, 5, 7, 8, 9, 8, 7, 9}));
    }

    private double findUnique(double[] array) {
        HashMap<Double, Integer> countValues = new HashMap<>();
        for (double v : array) {
            if (countValues.get(v) == null) {
                countValues.put(v, 1);
            } else {
                countValues.merge(v, 1, Integer::sum);
            }

        }
        return countValues.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey();
    }
}
