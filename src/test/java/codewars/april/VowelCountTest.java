package codewars.april;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class VowelCountTest {

  @Test
  void shouldCountVowels() {
    assertThat(countVowels("terra")).isEqualTo(2);
  }

  @Test
  void shouldCountVowelsEvenForUpperCase() {
    assertThat(countVowels("TERRARIUM")).isEqualTo(4);
  }

  private int countVowels(String input) {
    return input.length() - input.toLowerCase().replaceAll("([aeiou])", "").length();
  }

  @Test
  void shouldCountVowelsClever() {
    assertThat(countVowelsClever("TERRARIUM")).isEqualTo(4);
    assertThat(countVowelsClever("GiGaNtIuM")).isEqualTo(4);
  }

  /**
   * (?i)[^aeiou] (?i) - starts case-insensitive mode (?-i) - turns off case-insensitive mode
   * [^aeiou] - Negated set -
   * <p>
   * So All that is not in set remove
   */
  private int countVowelsClever(String input) {
    return input.replaceAll("(?i)[^aeiou]", "").length();
  }
}
