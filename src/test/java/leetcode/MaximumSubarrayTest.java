package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubarrayTest {

  @Test
  void test() {
    assertEquals(6, maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }

  @Test
  void testSmall() {
    assertEquals(-1, maxSubArray(new int[] {-2, -1}));
  }

  @Test
  void testMinus() {
    assertEquals(-1, maxSubArray(new int[] {-2, -3, -1}));
  }

  @Test
  void testBl() {
    assertEquals(187, maxSubArray(new int[] {31, -41, 59, 26, -53, 58, 97, -93, -23, 84}));
  }

  public int maxSubArray(int[] nums) {
    int maxSoFar = nums[0], maxEndingHere = nums[0];

    for (int i = 1; i < nums.length; i++) {
      maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
  }
}
