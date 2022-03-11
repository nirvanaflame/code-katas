package codewars.one.april;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Not ready")
class DragonsCurveTest {

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

  //Make the function; map the chars to Strings
  //a -> aRbFR, b -> LFaLb, otherwise -> itself
  private final IntFunction<String> mapFunction = (it) -> it == 'a' ? "aRbFR" : it == 'b' ? "LFaLB" : Character.toString(it);

  /**
   * Make the curve; stream the chars repeatedly (starting with Fa) through the mapFunction n times
   * Then remove the a and b (createFilter function is useful for that)
   */
  public String createCurve(int n) {
    if (n == 0) {
      return "F";
    }
    StringBuilder collect = new StringBuilder("Fa".chars().mapToObj(mapFunction).collect(Collectors.joining()));

    for (int i = 1; i < n; i++) {
      collect.append(
          collect.chars().peek(it -> System.err.println("" + it + " -< " + Character.toString(it))).mapToObj(mapFunction)
              .collect(Collectors.joining()));
      System.out.println("Times: " + i + "/" + n + " -> collect: " + collect);
    }

    return collect.toString().replaceAll("(?i)([a,b])", "");
  }

  /**
   * How many of the specified char are in the given curve? Hint: createFilter could be useful for
   * this
   */
  public long howMany(char c, String curve) {
    return curve.chars().filter(createFilter(c, true)).count();
  }

  /**
   * Create a predicate to filter the specified char; keep or remove based on keep variable
   */
  public IntPredicate createFilter(char filterWhat, boolean keep) {
    return value -> keep == (value == filterWhat);
  }
}
