package codewars.one.may;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.MathContext;
import org.junit.jupiter.api.Test;

class SquareTest {

  @Test
  void shouldReturnSquare() {
    assertThat(square(0)).isTrue();
    assertThat(square(4)).isTrue();
    assertThat(square(9)).isTrue();
    assertThat(square(25)).isTrue();
  }

  @Test
  void shouldReturnSquareFalse() {
    assertThat(square(-1)).isFalse();
    assertThat(square(3)).isFalse();
    assertThat(square(6)).isFalse();
  }

  @Test
  void shouldReturnFalseForBigNumbers() {
    assertThat(square(140310231)).isFalse();
  }

  boolean square(int i) {
    BigDecimal x = BigDecimal.valueOf(i);
    return i == 0 ||
        i > 0 &&
            x.sqrt(MathContext.DECIMAL32)
                .pow(2)
                .equals(x);
  }


  @Test
  void shouldReturnIsSquare() {
    assertThat(isSquare(0)).isTrue();
    assertThat(isSquare(4)).isTrue();
    assertThat(isSquare(9)).isTrue();
    assertThat(isSquare(25)).isTrue();
  }

  @Test
  void shouldReturnIsSquareFalse() {
    assertThat(isSquare(-1)).isFalse();
    assertThat(isSquare(3)).isFalse();
    assertThat(isSquare(6)).isFalse();
  }

  boolean isSquare(int n) {
    return Math.sqrt(n) % 1 == 0;
  }
}
