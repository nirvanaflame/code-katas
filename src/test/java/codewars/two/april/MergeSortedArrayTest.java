package codewars.two.april;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortedArrayTest {

  @Test
  @Disabled
  void testMergeSortedArray() {
    int[] expected = {1, 2, 2, 3, 5, 6};
    assertArrayEquals(expected, merge(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3));
  }

  @Test
  @Disabled
  void testMergeSortedArrayOneElement() {
    int[] expected = {1, 2};
    assertArrayEquals(expected, merge(new int[] {2, 0}, 1, new int[] {1}, 1));
  }

  int[] merge(int[] arr0, int n, int[] arr1, int m) {

    // System.out.println(Arrays.toString(arr0));

    int count = 0;
    for (int i = 0; i < arr0.length; i++) {
      int cur = arr0[i];
      int merge = arr1[count];

      if (cur > merge) {
        arr0[n] = cur;
        arr0[i] = merge;
      }
      if (count < m) count++;
    }

    return arr0;
  }
}
