package codewars.two.may;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitStringAsCoupleTest {

  @Test
  void testOddString() {
    String s = "abcde";
    String s1 = "LovePizza";
    assertEquals("[ab, cd, e_]", Arrays.toString(splitAsCoupe(s)));
    assertEquals("[Lo, ve, Pi, zz, a_]", Arrays.toString(splitAsCoupe(s1)));
  }

  String[] splitAsCoupe(String str) {
    String[] s = str.split("(?<=\\G..)");
    if (str.length() % 2 != 0) s[s.length - 1] += "_";
    return s;
  }
}
