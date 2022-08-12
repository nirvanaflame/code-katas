package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainsDuplicateTest {

  @Test
  void test() {
    assertTrue(containsDuplicate(new int[] {1, 2, 3, 1}));
  }

  public boolean containsDuplicate(int[] nums) {
    return nums.length > Arrays.stream(nums).distinct().count();
  }
}
