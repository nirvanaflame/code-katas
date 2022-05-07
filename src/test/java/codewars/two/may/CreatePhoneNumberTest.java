package codewars.two.may;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreatePhoneNumberTest {

  @Test
  void shouldReturnPhoneNumber() {
    assertEquals("(123) 456-7890", createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
  }

  String createPhoneNumber(int[] a) {
    return String.format("(%d%d%d) %d%d%d-%d%d%d%d", Arrays.stream(a).boxed().toArray());
  }
}
