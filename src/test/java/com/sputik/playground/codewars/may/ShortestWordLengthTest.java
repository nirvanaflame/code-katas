package com.sputik.playground.codewars.may;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

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
