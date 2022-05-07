package codewars.two.april;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class YourOrderPleaseTest {

  @Test
  void test1() {
    assertThat(order("is2 Thi1s T4est 3a")).isEqualTo("Thi1s is2 3a T4est");
  }

  @Test
  void test2() {
    assertThat(order("4of Fo1r pe6ople g3ood th5e the2"))
        .isEqualTo("Fo1r the2 g3ood 4of th5e pe6ople");
  }

  @Test
  void test81() {
    assertThat(order8("is2 Thi1s T4est 3a")).isEqualTo("Thi1s is2 3a T4est");
  }

  @Test
  void test82() {
    assertThat(order8("4of Fo1r pe6ople g3ood th5e the2"))
        .isEqualTo("Fo1r the2 g3ood 4of th5e pe6ople");
  }

  String order(String words) {
    String[] str = words.split(" ");

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= str.length; i++) {
      String order = String.valueOf(i);
      sb.append(Arrays.stream(str).filter(s -> s.contains(order)).findFirst().get());
      sb.append(" ");
    }

    return sb.toString().trim();
  }

  String order8(String words) {
    return Arrays.stream(words.split(" "))
        .sorted(Comparator.comparing(o -> o.replaceAll("\\D", "")))
        .collect(Collectors.joining(" "));
  }
}
