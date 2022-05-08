package codewars.two.may;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuildPileOfCubesTest {

  @Test
  void test1() {
    assertEquals(2022, findNb(4183059834009L));
  }

  @Test
  void test2() {
    assertEquals(-1, findNb(24723578342962L));
  }

  @Test
  void test3() {
    assertEquals(4824, findNb(135440716410000L));
  }

  @Test
  void test4() {
    assertEquals(3568, findNb(40539911473216L));
  }

  @Test
  void test5() {
    assertEquals(55100, findNb(2304422822859502500L));
  }

  @Test
  void test6() {
    assertEquals(53390, findNb(2031402397639835025L));
  }

  int findNb(long m) {
    long sum = 0;
    for (int i = 1; sum < m; i++) {
      sum += (long) Math.pow(i, 3);
      if (sum == m) return i;
    }

    return -1;
  }
}
