package codewars.two.may;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTowerTest {

  @Test
  void basicTests() {
    assertEquals(String.join(",", "*"), String.join(",", towerBuilder(1)));
    assertEquals(String.join(",", " * ", "***"), String.join(",", towerBuilder(2)));
    assertEquals(String.join(",", "  *  ", " *** ", "*****"), String.join(",", towerBuilder(3)));
  }


  /*
  * [
  "     *     ",
  "    ***    ",
  "   *****   ",
  "  *******  ",
  " ********* ",
  "***********"
]
  *
  * */
  private String[] towerBuilder(int l) {

    int len = l * 2 - 1;
    String[] r = new String[l];
    for(int i = r.length - 1, rep = len; i >= 0 ; i--, rep-=2) {
      int space = (len - rep) / 2;
      r[i] = " ".repeat(space) + "*".repeat(rep) + " ".repeat(space);
    }

    return r;
  }
}
