package codewars.two.may;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordTest {

  @Test
  void exampleCases() {
    assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", reverseWords("The quick brown fox jumps over the lazy dog."));
    assertEquals("elppa", reverseWords("apple"));
    assertEquals("a b c d", reverseWords("a b c d"));
    assertEquals("elbuod  decaps  sdrow", reverseWords("double  spaced  words"));
  }

  String reverseWords(String s) {
    return Arrays.stream(s.split(" "))
        .map(StringBuilder::new)
        .map(StringBuilder::reverse)
        .collect(Collectors.joining(" "));
  }
}
