package com.sputik.playground.codewars.may;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MaskifyTest {

  @Test
  void shouldReturnMaskedString() {
    assertThat(maskify("4556364607935616")).isEqualTo("############5616");
  }

  @Test
  void shouldNotMaskString() {
    assertThat(maskify("            1")).isEqualTo("1");
  }

  @Test
  void shouldReturnEmptyString() {
    assertThat(maskify("")).isEmpty();
  }

  @Test
  void shouldMaskSpaces() {
    assertThat(maskify("Nananananananananananananananana Batman!"))
        .isEqualTo("####################################man!");
  }

  @Test
  void shouldMaskString() {
    assertThat(maskify("Skippy")).isEqualTo("##ippy");
  }

  @Test
  void testShort() {
    assertThat(maskify("[ ]YB")).isEqualTo("# ]YB");
  }

  private String maskify(String s) {
    String str = s.trim();
    int length = str.length();
    int replace = length - 4;

    String result;
    if (length > 4) {
      String end = str.substring(replace, length);
      String hash = "#".repeat(replace);
      result = hash + end;
    } else {
      result = str;
    }

    return result;
  }
}
