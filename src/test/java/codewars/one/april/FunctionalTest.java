package codewars.one.april;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;
import org.junit.jupiter.api.Test;

class FunctionalTest {

  @Test
  void shouldAddToBase() {
    assertThat(add(123).apply(12)).isEqualTo(135);
  }

  @Test
  void shouldAddToBaseNegative() {
    assertThat(add(-5).apply(-10)).isEqualTo(-15);
  }

  private IntFunction<Integer> add(int base) {
    return value -> base + value;
  }

  @Test
  void shouldAddToInt() {
    assertThat(addToInt(-1).applyAsInt(10)).isEqualTo(9);
  }

  @Test
  void shouldAddToIntNegative() {
    assertThat(addToInt(-5).applyAsInt(-10)).isEqualTo(-15);
  }

  private ToIntFunction<Integer> addToInt(int base) {
    return value -> base + value;
  }

  @Test
  void shouldAddUnary() {
    assertThat(addUnary(-1).applyAsInt(10)).isEqualTo(9);
  }

  @Test
  void shouldAddUnaryNegative() {
    assertThat(addUnary(-5).applyAsInt(-2)).isEqualTo(-7);
  }

  private IntUnaryOperator addUnary(int base) {
    return it -> base + it;
  }
}
