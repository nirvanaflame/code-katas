package codewars.one.july;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Count the number of Duplicates Write a function that will return the count of distinct
 * case-insensitive alphabetic characters and numeric digits that occur more than once in the input
 * string. The input string can be assumed to contain only alphabets (both uppercase and lowercase)
 * and numeric digits.
 *
 * <p>Example "abcde" -> 0 # no characters repeats more than once "aabbcde" -> 2 # 'a' and 'b'
 * "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`) "indivisibility" -> 1 # 'i' occurs
 * six times "Indivisibility" -> 2 # 'i' occurs seven times and 's' occurs twice "aA11" -> 2 # 'a'
 * and '1' "ABBA" -> 2 # 'A' and 'B' each occur twice
 */
class CountingDuplicatesTest {

  @Test
  void shouldReturnZeroDuplicates() {
    assertEquals(0, duplicateCount("abcde"));
  }

  @Test
  void shouldReturnOneDuplicate() {
    assertEquals(1, duplicateCount("abcdea"));
  }

  @Test
  void shouldReturnOneDuplicateForMultipleOccurrences() {
    assertEquals(1, duplicateCount("indivisibility"));
  }

  @Test
  void reallyLongStringContainingDuplicatesReturnsThree() {
    String testThousandA = new String(new char[1000]).replace('\0', 'a');
    String testHundredB = new String(new char[100]).replace('\0', 'b');
    String testTenC = new String(new char[10]).replace('\0', 'c');
    String test1CapitalA = new String(new char[1]).replace('\0', 'A');
    String test1d = new String(new char[1]).replace('\0', 'd');
    String test = test1d + test1CapitalA + testTenC + testHundredB + testThousandA;

    assertEquals(3, duplicateCount(test));
  }

  private int duplicateCount(String str) {
    Map<String, Integer> map = new HashMap<>();

    for (String s : str.toLowerCase().split("")) {
      map.merge(s, 1, Integer::sum);
    }

    return (int) map.values().stream().filter(it -> it > 1).count();
  }
}
