package codewars.two.may;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TenMinutesWalkTest {

  @Test
  void shouldReturnTrue() {

    assertTrue(isValidWalk(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));
  }

  @Test
  void shouldReturnFalse_takesMoreThan10Minutes() {

    assertFalse(isValidWalk(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
  }

  @Test
  void shouldReturnFalse_wontGetBack() {

    assertFalse(isValidWalk(new char[] {'n','n','n','s','n','s','n','s','n','s'}));
  }

  boolean isValidWalk(char[] walks) {
    if (walks.length != 10) return false;

    int h = 0, v = 0;
    for (char c : walks)
      switch (c) {
        case 'n' -> h++;
        case 's' -> h--;
        case 'w' -> v++;
        case 'e' -> v--;
      }

    return h == 0 && v == 0;
  }
}
