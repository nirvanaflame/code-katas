package codewars.two.march;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PigLatinTest {

  @Test
  void test() {
    assertEquals("igPay atinlay siay oolcay", pigIt("Pig latin is cool"));
    assertEquals("hisTay siay ymay tringsay", pigIt("This is my string"));
  }

  @Test
  void testFixed() {
    assertEquals("oratay oay oresmay !", pigIt("tora o mores !"));
  }

  @Test
  void testBest() {
    assertEquals("oratay oay oresmay !", pigItBest("tora o mores !"));
  }

  @Test
  void testFunctional() {
    assertEquals("oratay oay oresmay !", pigItFunctional("tora o mores !"));
  }

  public String pigIt(String str) {
    String[] phrase = str.split(" ");

    StringBuilder sb = new StringBuilder();
    for (String word : phrase) {
      String[] ch = word.split("");
      String first = ch[0];

      for (int i = 1; i < ch.length; i++) {
        sb.append(ch[i]);
      }
      sb.append(first);

      int lastChar = sb.toString().codePointAt(sb.length() - 1);
      if (lastChar > 64 && lastChar < 123) {
        sb.append("ay ");
      }
    }

    return sb.toString().trim();
  }

  public String pigItBest(String str) {
    return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
  }

  public String pigItFunctional(String str) {
    return Arrays.stream(str.trim().split(" "))
        .map(
            v -> v.matches("[a-zA-Z]+") ? v.substring(1).concat(v.substring(0, 1)).concat("ay") : v)
        .collect(Collectors.joining(" "));
  }
}
