package codewars.two.march;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompoundPercentTest {

  @Test
  void findCompoundPercent() {
    assertEquals(3778, findCompoundPercent(365));
  }

  @Test
  void findCompoundPercent2() {
    assertEquals(3816, findCompoundPercent(366));
  }

  int findCompoundPercent(int days) {
    double base = 100;
    for (int i = 0; i < days; i++) {
      base += (base * 0.01);
    }
    return (int) base;
  }
}
