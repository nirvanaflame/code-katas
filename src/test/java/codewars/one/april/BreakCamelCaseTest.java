package codewars.one.april;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BreakCamelCaseTest {

  @Test
  void shouldSplitOnCamelCase() {
    assertThat(camelCase("camelCase")).isEqualTo("camel Case");
    assertThat(camelCase("camelCaseMore")).isEqualTo("camel Case More");
  }

  @Test
  void shouldReturnStringBack() {
    assertThat(camelCase("camelcase")).isEqualTo("camelcase");
  }

  @Test
  void shouldReturnSplitStrings() {
    assertThat(cleverCamelCase("camelCase")).isEqualTo("camel Case");
  }

  @Test
  void shouldNotSplitStrings() {
    assertThat(cleverCamelCase("camelcase")).isEqualTo("camelcase");
  }

  private String cleverCamelCase(String str) {
    return str.replaceAll("([A-Z])", " $1");
  }

  private String camelCase(String str) {
    String[] split = str.split("(?=[A-Z])");
    return Arrays.stream(split)
        .reduce("", (partialString, element) -> partialString + " ".concat(element))
        .trim();
  }
}
