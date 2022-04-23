package codewars.one.may;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled("Not finished")
class ReducingByStepsTest {

  @Test
  void shouldSum() {
    long[] a = new long[] {18, 69, -90, -78, 65, 40};

    assertThat(Operation.reduceArray(null, a, a[0]))
        .isEqualTo(new long[] {18, 18, -90, -90, -90, -90});
  }

  static class Operation {

    static long gcdi(long a, long b) {
      return Math.abs(a) + Math.abs(b);
    }

    static long lcmu(long a, long b) {
      return Math.abs(a) + Math.abs(b);
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

    static long[] reduceArray(UnaryOperator<Long> f, long[] arr, long init) {
      return null;
    }
  }
}
