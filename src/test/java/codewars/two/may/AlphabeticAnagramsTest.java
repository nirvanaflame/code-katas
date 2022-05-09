package codewars.two.may;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import static java.math.BigInteger.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AlphabeticAnagramsTest {

  @Test
  void testKnownInputs() {

    // assertEquals(ONE, listPosition("A"), "Position for 'A' incorrect");
    // assertEquals(valueOf(2), listPosition("ABAB"), "Position for 'ABAB' incorrect");
    // assertEquals(ONE, listPosition("AAAB"), "Position for 'AAAB' incorrect");
    // assertEquals(valueOf(4), listPosition("BAAA"), "Position for 'BAAA' incorrect");
    // assertEquals(BigInteger.valueOf(24572), listPosition("QUESTION"), "Position for 'QUESTION' incorrect");
    assertEquals(BigInteger.valueOf(10743), listPosition("BOOKKEEPER"), "Position for 'BOOKKEEPER' incorrect");

  }

  BigInteger listPosition(String str) {
    BigInteger factorial, result , count; result = factorial = count = ONE;

    HashMap<Character, BigInteger> letters = new HashMap<>();
    String reversed = new StringBuilder(str).reverse().toString();
    for (char c : reversed.toCharArray()) {
      letters.merge(c, ONE, BigInteger::add);

      factorial = factorial.multiply(count).divide(letters.get(c));

      for (char key : letters.keySet())
        if (key < c)
          result = result.add(
              factorial.divide(count).multiply(letters.get(key))
          );

      count = count.add(ONE);
    }

    return result;
  }

  BigInteger listPosition0(String str) {
    BigInteger factorial, result , count; result = factorial = count = ONE;

    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = str.length() - 1; i >= 0; --i) {
      factorial = factorial.multiply(count);

      char key = str.charAt(i);
      map.merge(key, 1, Integer::sum);

      factorial = factorial.divide(BigInteger.valueOf(map.get(key)));

      for (char c : map.keySet())
        if (c < key)
          result = result.add(
              factorial.divide(count)
                        .multiply(BigInteger.valueOf(map.get(c)))
          );

      count = count.add(ONE);
    }

    return result;
  }


}

class NiceTry {

  static SortedMap<String, Integer> cache = new TreeMap<>();

  BigInteger listPosition(String str) {

    HashMap<String, BigInteger> anagrams = new HashMap<>();
    for (String s : str.split("")) {
      anagrams.merge(s, ONE, BigInteger::add);
    }

    int length = anagrams.values().stream().reduce(BigInteger::add).get().intValue();
    BigInteger factorial = factorial(length);

    BigInteger count = anagrams.values().stream().map(it -> factorial(it.intValue())).reduce(BigInteger::multiply).get();

    return factorial.divide(count);
  }

  BigInteger anagram(String str) {
    permute(str, 0);

    BigInteger r = ONE;
    int i = 1;
    for (String s : cache.keySet()) {
      if (s.equals(str)) {r = valueOf(i); break;}
      i++;
    }
    cache = new TreeMap<>();
    return r;
  }

  BigInteger factorial(int length) {
    BigInteger b = ONE;
    if (length == 0) return b;

    for (int i = 2; i <= length; i++) {
      b = b.multiply(valueOf(i));
    }
    return b;
  }

  void permute(String str, int start) {

    if (start == str.length() - 1) {
      cache.putIfAbsent(str, 1);
      return;
    }

    for (int i = 0; i < str.length(); i++) {
      str = swap(str, start, i);
      permute(str, start + 1);
      str = swap(str, start, i);
    }
  }

  String swap(String str, int i, int j) {
    char[] c = str.toCharArray();
    char t = c[i];
    c[i] = c[j];
    c[j] = t;
    return String.valueOf(c);
  }

}

