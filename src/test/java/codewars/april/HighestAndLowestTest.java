package codewars.april;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class HighestAndLowestTest {

  @Test
  void shouldReturnHighestAndLowest() {
    assertThat(highAndLow("1 2 3 4 5")).isEqualTo("5 1");
  }

  @Test
  void shouldReturnHighestAndLowestNegative() {
    assertThat(highAndLow("1 2 3 4 -5")).isEqualTo("4 -5");
  }

  public String highAndLow(String numbers) {
    String[] arr = numbers.split("\\s");

    IntSummaryStatistics stats = Arrays.stream(arr)
        .map(Integer::valueOf)
        .collect(Collectors.summarizingInt(Integer::intValue));

    return stats.getMax() + " " + stats.getMin();
  }

  @Test
  void shouldReturnHighestAndLowestAlternative() {
    assertThat(highAndLowAlternative("1 2 3 4 5")).isEqualTo("5 1");
  }

  @Test
  void shouldReturnHighestAndLowestNegativeAlternative() {
    assertThat(highAndLowAlternative("1 2 3 4 -5")).isEqualTo("4 -5");
  }

  private String highAndLowAlternative(String s) {
    String[] arr = s.split("\\s");

    IntSummaryStatistics statistics = Arrays.stream(arr)
        .mapToInt(Integer::parseInt)
        .summaryStatistics();

    return statistics.getMax() + " " + statistics.getMin();
  }

}
