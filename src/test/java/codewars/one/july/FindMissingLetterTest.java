package codewars.one.july;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Find the missing letter
 *
 * <p>Write a method that takes an array of consecutive (increasing) letters as input and that
 * returns the missing letter in the array.
 *
 * <p>You will always get a valid array. And it will be always exactly one letter be missing. The
 * length of the array will always be at least 2. The array will always contain letters in only one
 * case.
 *
 * <p>Example:
 *
 * <p>['a','b','c','d','f'] -> 'e' ['O','Q','R','S'] -> 'P'
 *
 * <p>["a","b","c","d","f"] -> "e" ["O","Q","R","S"] -> "P"
 */
class FindMissingLetterTest {

  @Test
  void shouldReturnMissingLetter() {
    assertEquals('e', findMissingLetter(new char[] {'a', 'b', 'c', 'd', 'f'}));
  }

  @Test
  void shouldReturnMissingLetterEffective() {
    assertEquals('e', findMissingLetterEffective(new char[] {'a', 'b', 'c', 'd', 'f'}));
  }

  private char findMissingLetter(char[] chars) {
    return (char)
        IntStream.range(chars[0], chars[chars.length - 1])
            .filter(it -> !Arrays.toString(chars).contains(String.valueOf((char) it)))
            .findFirst()
            .getAsInt();
  }

  private char findMissingLetterEffective(char[] chars) {
    AtomicInteger prev = new AtomicInteger(chars[0]);

    return (char)
        (new String(chars).chars().filter(it -> it != prev.getAndIncrement()).findFirst().getAsInt()
            - 1);
  }
}
