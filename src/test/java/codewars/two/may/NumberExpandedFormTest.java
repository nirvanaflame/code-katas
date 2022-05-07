package codewars.two.may;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberExpandedFormTest {

  @Test
  void testSomething() {
    assertEquals("10 + 2", expandedForm(12));
    assertEquals("40 + 2", expandedForm(42));
    assertEquals("70000 + 300 + 4", expandedForm(70304));
    assertEquals("9000000", expandedForm(9000000));
  }

  String expandedForm(int n) {

    String outs = "";
    for (int i = 10; i < n; i *= 10) {
      int rem = n % i;
      outs = rem > 0 ? " + " + rem + outs : outs;
      n -= rem;
    }
    outs = n + outs;

    return outs;
  }
}
