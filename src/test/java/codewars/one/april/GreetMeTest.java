package codewars.one.april;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GreetMeTest {

  @Test
  void shouldCapitalize() {
    assertThat(capitalize("lowerCase")).isEqualTo("LowerCase");
  }

  @Test
  void shouldReturnCorrectName() {
    String name = "rIck";

    String greeting = greet(name);
    assertThat(greeting).isEqualTo("Hello Rick!");
  }

  private String greet(String name) {
    return "Hello " + capitalize(name.toLowerCase()) + "!";
  }

  private String capitalize(String str) {
    if (str.isEmpty()) {
      return "";
    }

    char[] chars = str.toCharArray();
    chars[0] = Character.toUpperCase(str.charAt(0));

    return new String(chars);
  }
}
