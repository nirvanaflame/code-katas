package codewars.april;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class CountPositiveSumNegativeTest {

  @Test
  void shouldReturnCountPositiveSumNegative() {
    assertThat(
        countPositiveSumNegative(new int[]{0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}))
        .isEqualTo(new int[]{8, -50});
  }

  @Test
  void shouldReturnZero() {
    assertThat(countPositiveSumNegativeSimple(null)).isEmpty();
  }

  private int[] countPositiveSumNegative(int[] input) {
    return isArrayNotEmpty(input) ? new int[]{countPositive(input), sumNegative(input)}
        : new int[0];
  }

  private boolean isArrayNotEmpty(int[] input) {
    return input != null && input.length > 0;
  }

  private int countPositive(int[] input) {
    return (int) Arrays.stream(input).filter(it -> it > 0).count();
  }

  private int sumNegative(int[] input) {
    return Arrays.stream(input).reduce(0, (base, x) -> x < 0 ? base + x : base);
  }

  @Test
  void shouldReturnCountPositiveSumNegativeSimple() {
    assertThat(
        countPositiveSumNegativeSimple(
            new int[]{0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}))
        .isEqualTo(new int[]{8, -50});
  }

  private int[] countPositiveSumNegativeSimple(int[] input) {
    return isArrayNotEmpty(input) ? new int[]{countPositive(input), sumNegativeSimple(input)}
        : new int[0];
  }

  private int sumNegativeSimple(int[] input) {
    return Arrays.stream(input).filter(it -> it < 0).sum();
  }

  @Test
  void theCleverestAccordingCodeWarsCommunity() {
    assertThat(
        countAndSumClever(
            new int[]{0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}))
        .isEqualTo(new int[]{8, -50});
  }

  private int[] countAndSumClever(int[] input) {
    return input == null || input.length == 0 ?
        new int[0] :
        new int[]{
            (int) Arrays.stream(input).filter(it -> it > 0).count(),
            Arrays.stream(input).filter(it -> it < 0).sum()
        };
  }
}
