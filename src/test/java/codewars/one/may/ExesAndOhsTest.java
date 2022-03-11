package codewars.one.may;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ExesAndOhsTest {

  @Test
  void shouldReturn() {
    assertThat(getXO("xxxXooOo")).isTrue();
    assertThat(getXO("zssddd")).isTrue();
  }

  boolean getXO(String s) {
    return s.replaceAll("(?i)[^x]", "")
               .length() == s.replaceAll("(?i)[^o]", "")
               .length();
  }
}
