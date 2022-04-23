package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveElementTest {

  @Test
  void removeElementTest() {
    assertEquals(
        2,
        removeElement(
            new int[] {
              3, 2, 2, 3,
            },
            3));
  }

  @Test
  void removeAllElementTest() {
    assertEquals(0, removeElement(new int[] {3, 3}, 3));
  }

  @Test
  void removeElementOneTest() {
    assertEquals(1, removeElement(new int[] {3, 3, 1}, 3));
  }

  @Test
  void removeElementFive() {
    assertEquals(5, removeElement(new int[] {0, 1, 2, 2, 3, 0, 4, 2}, 2));
  }

  @Test
  void removeElementAnother() {
    assertEquals(8, removeElement(new int[] {4, 2, 0, 2, 2, 1, 4, 4, 1, 4, 3, 2}, 4));
  }

  @Test
  void removeElementAnotherOne() {
    assertEquals(4, removeElement(new int[] {4, 1, 2, 4, 4, 0, 0}, 4));
  }

  public int removeElement(int[] nums, int val) {
    int last = nums.length - 1;

    for (int i = 0; i <= last; i++) {
      last = moveCorette(nums, val, last);

      if (nums[i] == val && i <= last) {
        nums[i] = nums[last];
        nums[last] = val;

        last--;
      }
    }

    return (int) Arrays.stream(nums).takeWhile(it -> it != val).count();
  }

  private int moveCorette(int[] nums, int val, int last) {
    for (int i = last; i > 0; i--) {
      if (nums[i] != val) {
        last = i;
        break;
      }
    }
    return last;
  }

  @Test
  void removeElementAnotherWhat() {
    assertEquals(8, removeElementWhat(new int[] {4, 2, 0, 2, 2, 1, 4, 4, 1, 4, 3, 2}, 4));
  }

  @Test
  void removeElementAnotherOneWhat() {
    assertEquals(4, removeElementWhat(new int[] {4, 1, 2, 4, 4, 0, 0}, 4));
  }

  public int removeElementWhat(int[] nums, int val) {
    int l = nums.length;
    for (int i = 0; i < l; i++) {
      if (nums[i] == val) {
        nums[i--] = nums[--l];
      }
    }
    return l;
  }
}
