package codingame;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Math.abs;
import static org.assertj.core.api.Assertions.assertThat;

class ClosestToZeroTest {

  @Test
  void shouldReturn1() {
    assertThat(closestToZero(12, 5, 3, -4, -2)).isEqualTo(-2);
  }

  @Test
  void shouldReturn2() {
    assertThat(closestToZero(12, 5, 3, -4, 0)).isZero();
  }

  @Test
  void shouldReturn3() {
    assertThat(closestToZero(12, 5, 3, -4, -3)).isEqualTo(3);
  }

  private int closestToZero(int... n) {
    return Arrays.stream(n)
        .boxed()
        .sorted(
            (a, b) -> {
              boolean notEqual = abs(a) != abs(b);
              int absMinus = abs(a) - abs(b);
              int minusReversed = b - a;
              return notEqual ? absMinus : minusReversed;
            })
        // .peek(System.out::println)
        .iterator()
        .next();
  }
}
