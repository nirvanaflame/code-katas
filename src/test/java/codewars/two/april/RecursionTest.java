package codewars.two.april;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursionTest {

  @Test
  void shouldSum() {
    assertEquals(9, recSum(new int[]{3, 4, 2}));
  }

  @Test
  void shouldSumOfArray() {
    assertEquals(9, sumOfArray(new int[]{3, 4, 2}, 2));
  }

  @Test
  void shouldTerSum() {
    assertEquals(9, terSum(new int[]{3, 4, 2}, 2));
  }

  int recSum(int[] a) {
    if (a.length == 1) return a[0];

    int[] subArray = Arrays.copyOfRange(a, 1, a.length);
    return a[0] + recSum(subArray);
  }

  int sumOfArray(int[] a, int n) {
    if (n == 0) return a[n];
    return a[n] + sumOfArray(a, n - 1);
  }

  int terSum(int[] a, int n) {
    return (n == 0) ? a[n] :  a[n] + terSum(a, n - 1);
  }
}
