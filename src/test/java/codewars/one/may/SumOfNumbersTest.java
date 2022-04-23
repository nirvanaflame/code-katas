package codewars.one.may;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfNumbersTest {

  @Test
  void shouldReturnTwo() {
    assertThat(getSum(-1, 2)).isEqualTo(2);
  }

  @Test
  void shouldWorkBothSide() {
    assertThat(getSum(4, -2)).isEqualTo(7);
  }

  int getSum(int a, int b) {
    int max, min;
    if (a > b) {
      max = a;
      min = b;
    } else {
      max = b;
      min = a;
    }
    return IntStream.rangeClosed(min, max).sum();
  }

  @Test
  void testGetSumWithMath() {
    assertThat(getSumMath(4, -2)).isEqualTo(7);
  }

  int getSumMath(int a, int b) {
    return IntStream.rangeClosed(Math.min(a, b), Math.max(a, b)).sum();
  }

  @Test
  void testGetSumWithMathExpression() {
    assertThat(mathExpression(4, -2)).isEqualTo(7);
  }

  /* if a = -3 and b = 2 then
   *  (-3 + 2) * (|-3 - 2| + 1) / 2
   *  -1 * 6 / 2
   *  which is -3
   *  -3 -2 -1 0 1 2
   */
  int mathExpression(int a, int b) {
    return (a + b) * (Math.abs(a - b) + 1) / 2;
  }
}
