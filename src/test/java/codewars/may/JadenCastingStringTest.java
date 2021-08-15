package codewars.may;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class JadenCastingStringTest {

  @Test
  void shouldReturnJadenStringNull() {
    assertThat(toJadenCase(null)).isNull();
  }

  @Test
  void shouldReturnJadenStringEmpty() {
    assertThat(toJadenCase(" ")).isNull();
  }

  @Test
  void shouldReturnJadenString() {
    assertThat(toJadenCase("How can mirrors be real if our eyes aren't real"))
        .isEqualTo("How Can Mirrors Be Real If Our Eyes Aren't Real");
  }

  String toJadenCase(String s) {
    if (s == null || s.isBlank()) {
      return null;
    }

    return Arrays.stream(s.split(" "))
        .map(this::capitalize)
        .collect(Collectors.joining(" "));
  }

  String capitalize(String str) {
    return String.valueOf(str.charAt(0))
        .toUpperCase()
        + str.substring(1);
  }

}
