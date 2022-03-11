package codewars.one.may;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GrowthOfPopulationTest {

  @Test
  void shouldReturnYears() {
    assertThat(calculateYears(1500, 5, 100, 5000)).isEqualTo(15);
  }

  @Test
  void shouldReturnYearsExample() {
    assertThat(calculateYears(1000, 2, 50, 1200)).isEqualTo(3);
  }

  int calculateYears(int p0, double percent, int aug, int p) {
    double base = p0;
    int years = 0;
    while (base < p) {
      base += Math.ceil(base * percent / 100 + aug + 0.5);
      years++;
    }

    return years;
  }
}
