package codewars.one.may;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TriangleTest {

  @Test
  void shouldReturnYes() {
    assertThat(isTriangle(1, 2, 2)).isTrue();
  }

  @Test
  void shouldReturnNo() {
    assertThat(isTriangle(2, 3, 6)).isFalse();
  }

  @Test
  void shouldReturnNoNo() {
    assertThat(isTriangle(1, 2, 3)).isFalse();
  }

  private boolean isTriangle(int a, int b, int c) {
    return (a + b) > c && (b + c) > a && (a + c) > b;
  }
}
