package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class NextPermutationTest {

    @Test
    @Disabled
    void permutationTest() {
        int[] actual = {1, 2, 3};
        int[] expected = {1, 3, 2};
        Assertions.assertArrayEquals(expected, nextPermutation(actual));
    }

    public int[] nextPermutation(int[] nums) {

        return new int[]{2, 3};
    }
}
