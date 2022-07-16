package codewars.one.april;

import org.junit.jupiter.api.Test;

import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class DragonsCurveTest {

  // Make the function; map the chars to Strings
  // a -> aRbFR, b -> LFaLb, otherwise -> itself
  final IntFunction<String> mapFunction =
      it -> it == 'a' ? "aRbFR" : it == 'b' ? "LFaLb" : Character.toString(it);

  @Test
  void callZeroTimes() {
    assertThat(createCurve(0)).isEqualTo("F");
  }

  @Test
  void callOneTime() {
    assertThat(createCurve(1)).isEqualTo("FRFR");
  }

  @Test
  void callTwoTimes() {
    assertThat(createCurve(2)).isEqualTo("FRFRRLFLFR");
  }

  @Test
  void callThreeTimes() {
    assertThat(createCurve(3)).isEqualTo("FRFRRLFLFRRLFRFRLLFLFR");
  }

  @Test
  void callFiveTimes() {
    assertThat(createCurve(5)).isEqualTo("FRFRRLFLFRRLFRFRLLFLFRRLFRFRRLFLFRLLFRFRLLFLFRRLFRFRRLFLFRRLFRFRLLFLFRLLFRFRRLFLFRLLFRFRLLFLFR");
  }

  /**
   * Make the curve; stream the chars repeatedly (starting with Fa) through the mapFunction n times
   * Then remove the a and b (createFilter function is useful for that)
   */
  public String createCurve(int n) {
    StringBuilder sb = new StringBuilder("fa");
    for (int i = 0; i < n; i++) {
      sb = new StringBuilder(sb.chars().mapToObj(mapFunction).collect(Collectors.joining()));
    }

    return n > 0 ? sb.toString().chars()
        .filter(createFilter('a', false).and(createFilter('b', false)))
        .mapToObj(Character::toString)
        .collect(Collectors.joining()).toUpperCase()
        : "F";
  }

  /**
   * How many of the specified char are in the given curve? Hint: createFilter could be useful for
   * this
   */
  public long howMany(char c, String curve) {
    return curve.chars().filter(createFilter(c, true)).count();
  }

  /** Create a predicate to filter the specified char; keep or remove based on keep variable */
  public IntPredicate createFilter(char filterWhat, boolean keep) {
    return value -> keep == (value == filterWhat);
  }
}
