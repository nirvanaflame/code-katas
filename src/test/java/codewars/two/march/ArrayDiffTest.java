package codewars.two.march;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


/*
 * Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.
 * It should remove all values from list a, which are present in list b keeping their order.
 * */
public class ArrayDiffTest {

    @Test
    public void whenMatchThenRemove() {
        assertArrayEquals(new int[]{2}, arrayDiff(new int[]{1, 2}, new int[]{1}));

    }

    @Test
    public void whenOneMatchThenAShouldHaveTwo() {
        assertArrayEquals(new int[]{2, 2}, arrayDiff(new int[]{1, 2, 2}, new int[]{1}));
    }

    @Test
    public void whenTwoMatchThenAOnlyOne() {
        assertArrayEquals(new int[]{1}, arrayDiff(new int[]{1, 2, 2}, new int[]{2}));
    }

    @Test
    public void whenEmptyBThenReturnAForResult() {
        assertArrayEquals(new int[]{1, 2, 2}, arrayDiff(new int[]{1, 2, 2}, new int[]{}));
    }

    @Test
    public void whenEmptyAThenEmptyResult() {
        assertArrayEquals(new int[]{}, arrayDiff(new int[]{}, new int[]{1, 2}));
    }

    @Test
    public void whenRandomTestThenPass() {
        int[] a = {17, 17, 5, 14, 12, 7, 14, 4, 21, 3, 9, 12, 15, 20, 0, 22, 1, 19, 8, 9, 9,
                16, 6, 14, 15, 12, 10, 11, 19, 10, 3, 16, 13, 24, 24, 22, 17, 19, 23, 21, 19,
                15, 8, 6, 0, 20, 15, 3, 6, 21, 4, 6, 2, 6, 22, 2, 3, 0, 13};

        int[] b = {24, 14, 18, 7, 22, 8, 18, 19, 8, 1, 18, 7, 5, 23, 18, 9, 6, 20, 0, 13, 8,
                0, 16, 15, 21, 24, 3, 21, 11, 4, 7, 22, 14, 13, 1, 5, 20};

        assertEquals(10, arrayDiff(a, b).length);
    }

    @Test
    public void whenRandomTestThenPassBest() {
        int[] a = {17, 17, 5, 14, 12, 7, 14, 4, 21, 3, 9, 12, 15, 20, 0, 22, 1, 19, 8, 9, 9,
                16, 6, 14, 15, 12, 10, 11, 19, 10, 3, 16, 13, 24, 24, 22, 17, 19, 23, 21, 19,
                15, 8, 6, 0, 20, 15, 3, 6, 21, 4, 6, 2, 6, 22, 2, 3, 0, 13};

        int[] b = {24, 14, 18, 7, 22, 8, 18, 19, 8, 1, 18, 7, 5, 23, 18, 9, 6, 20, 0, 13, 8,
                0, 16, 15, 21, 24, 3, 21, 11, 4, 7, 22, 14, 13, 1, 5, 20};

        assertEquals(10, arrayDiffBest(a, b).length);
    }

    int[] arrayDiff(int[] a, int[] b) {
        int[] sorted = stream(b).sorted().toArray();

        return stream(a).filter(it -> Arrays.binarySearch(sorted, it) < 0).toArray();
    }

    int[] arrayDiffBest(int[] a, int[] b) {
        return stream(a).filter(x -> stream(b).noneMatch(y -> x == y)).toArray();
    }
}
