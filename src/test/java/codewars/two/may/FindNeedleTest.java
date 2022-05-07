package codewars.two.may;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindNeedleTest {

  @Test
  void shouldReturnIndexOfNeedle() {
    Object[] haystack1 = {"3", "123124234", null, "needle", "world", "hay", 2, "3", true, false};

    assertEquals("found the needle at position 3", findNeedle(haystack1));
  }

  String findNeedle(Object[] haystack) {
    for (int i = 0; i < haystack.length; i++)
      if(("" + haystack[i]).equals("needle")) return "found the needle at position " + i;

    return "";
  }
}
