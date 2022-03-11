package codewars.april;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class AlphabetSymmetryTest {

  private final static String alphabet = "abcdefghijklmnopqrstuvwxyz";

  @Test
  void shouldReturnArrayOfSymmetriesLength() {
    assertArrayEquals(new int[]{4, 3, 1},
        countSymmetry(new String[]{"abode", "ABc", "xyzD"}));

    assertArrayEquals(new int[]{4, 3, 0},
        countSymmetry(new String[]{"abide", "ABc", "xyz"}));

    assertArrayEquals(new int[]{6, 5, 7},
        countSymmetry(new String[]{"IAMDEFANDJKL", "thedefgh", "xyzDEFghijabc"}));

  }

  @Test
  void testStringWithLengthBiggerThanAlphabet() {
    assertArrayEquals(new int[]{1, 26, 1, 3},
        countSymmetry(new String[]{"encode", "abcdefghijklmnopqrstuvwxyzdead", "xyzD", "ABmD"}));
  }

  private int[] countSymmetry(String[] input) {
    return Arrays.stream(input)
        .map(String::toLowerCase)
        .map(str -> str.length() > alphabet.length() ? str.substring(0, alphabet.length()) : str)
        .map(str -> IntStream
            .range(0, str.length())
            .filter(i -> alphabet.charAt(i) == str.charAt(i))
            .count()
        )
        .mapToInt(Long::intValue)
        .toArray();
  }

  @Test
  void testCleverSolution() {
    assertArrayEquals(new int[]{1, 26, 1, 3},
        cleverCountSymmetry(new String[]{"encode", "abcdefghijklmnopqrstuvwxyzd", "xyzD", "ABmD"}));
  }

  private int[] cleverCountSymmetry(String[] input) {
    return Arrays.stream(input)
        .map(String::toLowerCase)
        .mapToInt(this::calcSymmetryLength)
        .toArray();
  }

  private int calcSymmetryLength(String str) {
    return IntStream.range(0, str.length())
        .filter(i -> alphabet.indexOf(str.charAt(i)) == i)
        .toArray().length;
  }
}
