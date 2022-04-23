package codewars.one.may;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExesAndOhsTest {

  @Test
  void shouldReturn() {
    assertThat(getXO("xxxXooOo")).isTrue();
    assertThat(getXO("zssddd")).isTrue();
  }

  boolean getXO(String s) {
    return s.replaceAll("(?i)[^x]", "").length() == s.replaceAll("(?i)[^o]", "").length();
  }
}
