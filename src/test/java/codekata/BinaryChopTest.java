package codekata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryChopTest {

  @Test
  void chop() {
    assertEquals(-1, chop(3, new int[]{}));
    assertEquals(-1, chop(3, new int[]{1}));
    assertEquals(0,  chop(1, new int[]{1}));
    //
    assertEquals(0,  chop(1, new int[]{1, 3, 5}));
    assertEquals(1,  chop(3, new int[]{1, 3, 5}));
    assertEquals(2,  chop(5, new int[]{1, 3, 5}));
    assertEquals(-1, chop(0, new int[]{1, 3, 5}));
    assertEquals(-1, chop(2, new int[]{1, 3, 5}));
    assertEquals(-1, chop(4, new int[]{1, 3, 5}));
    assertEquals(-1, chop(6, new int[]{1, 3, 5}));
    //
    assertEquals(0,  chop(1, new int[]{1, 3, 5, 7}));
    assertEquals(1,  chop(3, new int[]{1, 3, 5, 7}));
    assertEquals(2,  chop(5, new int[]{1, 3, 5, 7}));
    assertEquals(3,  chop(7, new int[]{1, 3, 5, 7}));
    assertEquals(-1, chop(0, new int[]{1, 3, 5, 7}));
    assertEquals(-1, chop(2, new int[]{1, 3, 5, 7}));
    assertEquals(-1, chop(4, new int[]{1, 3, 5, 7}));
    assertEquals(-1, chop(6, new int[]{1, 3, 5, 7}));
    assertEquals(-1, chop(8, new int[]{1, 3, 5, 7}));
  }

  @Test
  void chop2() {
    assertEquals(-1, chop2(3, new int[]{}));
    assertEquals(-1, chop2(3, new int[]{1}));
    assertEquals(0,  chop2(1, new int[]{1}));
    //2
    assertEquals(0,  chop2(1, new int[]{1, 3, 5}));
    assertEquals(1,  chop2(3, new int[]{1, 3, 5}));
    assertEquals(2,  chop2(5, new int[]{1, 3, 5}));
    assertEquals(-1, chop2(0, new int[]{1, 3, 5}));
    assertEquals(-1, chop2(2, new int[]{1, 3, 5}));
    assertEquals(-1, chop2(4, new int[]{1, 3, 5}));
    assertEquals(-1, chop2(6, new int[]{1, 3, 5}));
    //2
    assertEquals(0,  chop2(1, new int[]{1, 3, 5, 7}));
    assertEquals(1,  chop2(3, new int[]{1, 3, 5, 7}));
    assertEquals(2,  chop2(5, new int[]{1, 3, 5, 7}));
    assertEquals(3,  chop2(7, new int[]{1, 3, 5, 7}));
    assertEquals(-1, chop2(0, new int[]{1, 3, 5, 7}));
    assertEquals(-1, chop2(2, new int[]{1, 3, 5, 7}));
    assertEquals(-1, chop2(4, new int[]{1, 3, 5, 7}));
    assertEquals(-1, chop2(6, new int[]{1, 3, 5, 7}));
    assertEquals(-1, chop2(8, new int[]{1, 3, 5, 7}));
  }


  private int chop(int n, int[] a) {
    int low = 0;
    int high = a.length - 1;

    int middle;
    while (low <= high) {
      middle = (low + high) / 2;

      int v = a[middle];
      if (v == n) return middle;
      if (v > n) {
        high = middle - 1;
      } else {
        low = middle + 1;
      }
    }

    return -1;
  }

  private int chop2(int n, int[]a) {
    return a.length < 1 ? -1 : recursiveChop(n, a, 0, a.length - 1);
  }

  private int recursiveChop(int n, int[] a, int low, int high) {
    if (low > high) return -1;

    int mid = (low + high) / 2;
    if (a[mid] == n) return mid;

    return a[mid] > n ?
        recursiveChop(n, a, low, high = mid - 1) :
        recursiveChop(n, a, low = mid + 1, high);
  }
}