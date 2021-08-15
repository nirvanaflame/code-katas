package codewars.may;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ChocolateTest {

  @Test
  void shouldReturnNumber() {
    assertThat(breakChocolate(5, 5)).isEqualTo(24);
  }

  @Test
  void shouldReturnAlternative() {
    assertThat(breakChocolateAlternative(5, 5)).isEqualTo(24);
  }

  private int breakChocolate(int n, int m) {
    return n * m > 1 ? n * m - 1 : 0;
  }

  private int breakChocolateAlternative(int n, int m) {
    return Math.max(n * m - 1, 0);
  }
}
