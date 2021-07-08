package com.sputik.playground.codewars.april;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class SquareDigitsTest {

  @Test
  void shouldSquareDigits() {
    assertThat(squareDigits(9119)).isEqualTo(811181);
    assertThat(squareDigits(80194)).isEqualTo(64018116);
  }

  private int squareDigits(int n) {
    String digits = String.valueOf(n);

    StringBuilder sb = new StringBuilder();

    for (char c : digits.toCharArray()) {
      int num = Character.getNumericValue(c);
      sb.append(num * num);
    }
    return Integer.parseInt(sb.toString());
  }

  @Test
  void shouldSquareDigitsFunctionally() {
    assertThat(squareDigitsFunctional(9119)).isEqualTo(811181);
    assertThat(squareDigitsFunctional(80194)).isEqualTo(64018116);
  }

  private int squareDigitsFunctional(int n) {
    return Integer.parseInt(String.valueOf(n)
        .chars()
        .map(Character::getNumericValue)
        .map(it -> it * it)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining())
    );
  }
}
