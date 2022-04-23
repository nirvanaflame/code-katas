package codewars.two.march;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpstringsTest {

  public static String vertMirror(String str) {
    return Arrays.stream(str.split("\n"))
        .map(StringBuilder::new)
        .map(StringBuilder::reverse)
        .collect(Collectors.joining("\n"));
  }

  public static String horMirror(String str) {
    /*        String[] arr = str.split("\n");
    StringBuilder sb = new StringBuilder();
    for (int i = arr.length-1; i >= 0; i--) {
        sb.append(arr[i]).append("\n");
    }
    return sb.toString().trim();*/

    String[] split = str.split("\n");
    int last = split.length - 1;

    return IntStream.rangeClosed(0, last)
        .mapToObj(i -> split[last - i])
        .collect(Collectors.joining("\n"));
  }

  public static String oper(Function<String, String> operator, String str) {
    return operator.apply(str);
  }

  @Test
  void shouldReturnVerticalMirror() {
    String actual = "hSgdHQ\nHnDMao\nClNNxX\niRvxxH\nbqTVvA\nwvSyRu";
    String exp = "QHdgSh\noaMDnH\nXxNNlC\nHxxvRi\nAvVTqb\nuRySvw";
    assertEquals(exp, OpstringsTest.oper(OpstringsTest::vertMirror, actual));
  }

  @Test
  void shouldReturnVerticalMirrorTwo() {
    String actual = "IzOTWE\nkkbeCM\nWuzZxM\nvDddJw\njiJyHF\nPVHfSx";
    String exp = "EWTOzI\nMCebkk\nMxZzuW\nwJddDv\nFHyJij\nxSfHVP";
    assertEquals(exp, OpstringsTest.oper(OpstringsTest::vertMirror, actual));
  }

  @Test
  void shouldReturnHorizontalMirrorTwo() {
    String actual = "lVHt\nJVhv\nCSbg\nyeCt";
    String exp = "yeCt\nCSbg\nJVhv\nlVHt";
    assertEquals(exp, OpstringsTest.oper(OpstringsTest::horMirror, actual));
  }

  @Test
  void shouldReturnHorizontalMirror() {
    String actual = "njMK\ndbrZ\nLPKo\ncEYz";
    String exp = "cEYz\nLPKo\ndbrZ\nnjMK";
    assertEquals(exp, OpstringsTest.oper(OpstringsTest::horMirror, actual));
  }
}
