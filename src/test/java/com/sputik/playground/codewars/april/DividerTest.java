package com.sputik.playground.codewars.april;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class DividerTest {

  @Test
  void fourTest() {
    assertThat(FindDivisor.numberOfDivisors(4)).isEqualTo(3);
  }

  @Test
  void fiveTest() {
    assertThat(FindDivisor.numberOfDivisors(5)).isEqualTo(2);
  }

  @Test
  void twelveTest() {
    assertThat(FindDivisor.numberOfDivisors(12)).isEqualTo(6);

  }

  @Test
  void thirtyTest() {
    assertThat(FindDivisor.numberOfDivisorsFunctional(30)).isEqualTo(8);
  }

  @SuppressWarnings("UtilityClassWithoutPrivateConstructor")
  static class FindDivisor {

    public static long numberOfDivisors(int n) {
      int count = 0;

      for (int i = n; i > 0; i--) {
        if (n % i == 0) {
          count++;
        }
      }

      return count;
    }

    public static long numberOfDivisorsFunctional(int n) {
      return IntStream.range(1, n + 1)
          .reduce(0, (acc, x) -> n % x == 0 ? acc + 1 : acc);
    }
  }
}