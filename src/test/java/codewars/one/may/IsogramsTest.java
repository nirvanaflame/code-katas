package codewars.one.may;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class IsogramsTest {

  @Test
  void shouldReturnTrueForIsograms() {
    assertThat(isgoram("Dermatoglyphics")).isTrue();
  }

  @Test
  void shouldReturnFalseForNotIsograms() {
    assertThat(isgoram("aba")).isFalse();
  }

  @Test
  void shouldReturnFalseForNotIsogramsIgnoreCase() {
    assertThat(isgoram("moOse")).isFalse();
  }

  boolean isgoram(String s) {
    return s.length() == s.toLowerCase().chars().boxed().collect(Collectors.toSet()).size();
  }

  @Test
  void shouldReturnTrueForIsogramsSimple() {
    assertThat(isgoramSimple("Dermatoglyphics")).isTrue();
  }

  boolean isgoramSimple(String s) {
    return s.length() == s.toLowerCase().chars().boxed().distinct().count();
  }
}
