package codewars.one.may;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.LongBinaryOperator;

import static codewars.one.may.ReducingByStepsTest.Operation.reduceArray;
import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReducingByStepsTest {

  private static void testing(String actual, String expected) {
    assertEquals(expected, actual);
  }

  @Test
  public void test0() {
    long[] a = new long[] {18, 69, -90, -78, 65, 40};

    long[] r = new long[] {18, 3, 3, 3, 1, 1};
    testing(Arrays.toString(reduceArray(Operation::gcdi, a, a[0])), Arrays.toString(r));
    r = new long[] {18, 414, 2070, 26910, 26910, 107640};
    testing(Arrays.toString(reduceArray(Operation::lcmu, a, a[0])), Arrays.toString(r));
    r = new long[] {18, 87, -3, -81, -16, 24};
    testing(Arrays.toString(reduceArray(Operation::som, a, 0)), Arrays.toString(r));
    r = new long[] {18, 18, -90, -90, -90, -90};
    testing(Arrays.toString(reduceArray(Operation::mini, a, a[0])), Arrays.toString(r));
    r = new long[] {18, 69, 69, 69, 69, 69};
    testing(Arrays.toString(reduceArray(Operation::maxi, a, a[0])), Arrays.toString(r));
  }

  static class Operation {

    static long gcdi(long n1, long n2) {
      return gcd(abs(n1), abs(n2));
    }

    static long gcd(long n1, long n2) {
      return n2 == 0 ? n1 : gcdi(n2, n1 % n2);
    }

    static long lcmu(long first, long second) {
      return lcm(abs(first), abs(second));
    }

    static long lcm(long n1, long n2) {
      return (n1 == 0 || n2 == 0) ? 0 :abs(n1 * n2) / gcdi(n1, n2);
    }

    static long som(long a, long b) {
      return a + b;
    }

    static long maxi(long a, long b) {
      return Math.max(a, b);
    }

    static long mini(long a, long b) {
      return Math.min(a, b);
    }

    static long[] reduceArray(LongBinaryOperator f, long[] arr, long init) {
      long[] res = new long[arr.length];
      int i = 0;
      for (long l : arr) {
        init = f.applyAsLong(init, l);
        res[i++] = init;
      }
      return res;
    }
  }
}
