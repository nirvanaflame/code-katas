package com.sputik.playground;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class AssertAllExampleTest {

  @Test
  void shouldCheckAllItemsInTheList() {
    List<Integer> numbers = List.of(1, 2, 3, 4);
    assertAll(
        () -> assertEquals(1, numbers.get(0)),
        () -> assertEquals(2, numbers.get(1)),
        () -> assertEquals(3, numbers.get(2)),
        () -> assertEquals(4, numbers.get(3)));
  }
}
