package com.sputik.playground.codewars.april;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class StringEndingTest {

  @Test
  void shouldVerifyStringEnding() {
    assertAll(() -> {
      assertThat(stringContainsEnding("abc", "c")).isTrue();
      assertThat(stringContainsEnding("abc", "bc")).isTrue();
      assertThat(stringContainsEnding("abc", "abc")).isTrue();
      assertThat(stringContainsEnding("cba", "b")).isFalse();
      assertThat(stringContainsEnding("cba", "bc")).isFalse();
      assertThat(stringContainsEnding("cb", "bca")).isFalse();
    });
  }

  @Test
  void howKataSupposedToBeSolved() {
    assertThat(smartComparison("abc", "bc")).isTrue();
    assertThat(smartComparison("adc", "calc")).isFalse();
  }

  private boolean smartComparison(String base, String ending) {
    return base.endsWith(ending);
  }

  private boolean stringContainsEnding(String base, String ending) {
    return base.length() >= ending.length() && compareIntStreams(
        base.subSequence(base.length() - ending.length(), base.length()).chars(),
        ending.chars()
    );
  }

  private boolean compareIntStreams(IntStream s1, IntStream s2) {
    Set<Integer> set = s2.boxed().collect(Collectors.toSet());
    return s1.allMatch(set::contains);
  }
}
