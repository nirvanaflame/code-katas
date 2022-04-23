package codewars.one.may;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class FactorialTest {

  @Test
  void shouldReturnFactRec() {
    assertThat(factRec(5)).isEqualTo(120);
  }

  @Test
  void shouldReturnFactStream() {
    assertThat(factStream(5)).isEqualTo(120);
  }

  @Test
  void shouldReturnFactFor() {
    assertThat(factFor(5)).isEqualTo(120);
  }

  int factRec(int n) {
    if (n <= 2) {
      return n;
    }
    return n * factRec(n - 1);
  }

  int factStream(int n) {
    return IntStream.rangeClosed(1, n).reduce(1, (acc, each) -> acc * each);
  }

  int factFor(int n) {
    int base = 1;
    for (int i = 2; i <= n; i++) {
      base *= i;
    }

    return base;
  }
}
