package com.sputik.playground.codewars.april;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class MumblingTest {

  @Test
  void shouldReturn() {
    assertThat(mumble("ZpglnRxqenU"))
        .isEqualTo("Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu");
  }

  String mumble(String str) {
    AtomicInteger count = new AtomicInteger();
    String reduce = str.toLowerCase()
        .chars()
        .mapToObj(Character::toString)
        .reduce("", (acc, each) -> acc + each.toUpperCase() + each.repeat(
            count.getAndIncrement()) + "-");

    return reduce.substring(0, reduce.length() - 1);
  }

  @Test
  void shouldReturnClever() {
    assertThat(cleverSolution("ZpglnRxqenU"))
        .isEqualTo("Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu");
  }

  String cleverSolution(String s) {
    return IntStream.range(0, s.length())
        .mapToObj(i -> IntStream.range(0, i + 1)
            .mapToObj(i1 -> i1 == 0 ? String.valueOf(s.charAt(i))
                .toUpperCase()
                : String.valueOf(s.charAt(i))
                    .toLowerCase())
            .collect(Collectors.joining())
        )
        .collect(Collectors.joining("-"));
  }
}
