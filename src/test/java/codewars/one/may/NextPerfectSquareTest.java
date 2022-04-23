package codewars.one.may;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NextPerfectSquareTest {

  @Test
  void shouldReturnNextSquare() {
    assertThat(findNextPerfectSquare(121)).isEqualTo(144);
  }

  @Test
  void shouldReturnMinusOne() {
    assertThat(findNextPerfectSquare(114)).isEqualTo(-1);
  }

  long findNextPerfectSquare(int n) {
    double root = Math.sqrt(n);
    return root % 1 == 0 ? (long) Math.pow(root + 1, 2) : -1;
  }
}
