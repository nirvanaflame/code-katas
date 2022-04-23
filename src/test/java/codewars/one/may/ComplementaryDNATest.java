package codewars.one.may;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("SpellCheckingInspection")
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
    return switch (it) {
      case 'A' -> 'T';
      case 'T' -> 'A';
      case 'G' -> 'C';
      case 'C' -> 'G';
      default -> ' ';
    };
  }
}
