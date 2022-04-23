package codewars.one.may;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ComplementaryDNATest {

  @Test
  void shouldReturnComplementary() {
    assertThat(makeComplement("ATTGC")).isEqualTo("TAACG");
    assertThat(makeComplement("GTAT")).isEqualTo("CATA");
  }

  private String makeComplement(String str) {
    return str.chars()
        .mapToObj(this::complement)
        .map(Character::toString)
        .collect(Collectors.joining());
  }

  private int complement(int it) {
    switch (it) {
      case 'A':
        return 'T';
      case 'T':
        return 'A';
      case 'G':
        return 'C';
      case 'C':
        return 'G';
      default:
        return ' ';
    }
  }
}
