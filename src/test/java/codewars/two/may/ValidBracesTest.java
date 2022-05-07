package codewars.two.may;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidBracesTest {

  @Test
  void testValid() {
    assertEquals(true, bracesAreValid("()"));
  }

  @Test
  void testInvalid() {
    assertEquals(false, bracesAreValid("[(])"));
  }

  @Test
  void testInvalid2() {
    assertEquals(false, bracesAreValid(")(}{]["));
  }

  boolean bracesAreValid(String str) {
    LinkedList<String> list = new LinkedList<>();
    for (String s : str.split("")) {
     boolean isOkay = switch (s) {
        case "{", "(", "[" -> list.add(s);
        case "}", ")", "]" -> !list.isEmpty() && opposite(list.removeLast(), s);
       default -> false;
       };
     if (!isOkay) return false;
    }

    return list.isEmpty();
  }

  boolean opposite(String p, String c) {
    return switch (p){
      case "(" -> c.equals(")");
      case "[" -> c.equals("]");
      case "{" -> c.equals("}");
      default -> false;
    };
  }
}
