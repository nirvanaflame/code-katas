package codewars.one.may;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ShortestWordLengthTest {

  @Test
  void shouldReturnShortestWordLength() {
    assertThat(shortestWordLength("Let's travel abroad shall we")).isEqualTo(2);
    assertThat(shortestWordLength("bitcoin take over the world maybe who knows perhaps"))
        .isEqualTo(3);
  }

  private int shortestWordLength(String s) {
    return Arrays.stream(s.split("\\s")).mapToInt(String::length).min().orElse(0);
  }
}
