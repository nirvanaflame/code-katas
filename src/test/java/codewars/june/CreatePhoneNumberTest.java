package codewars.june;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class CreatePhoneNumberTest {

  @Test
  void shouldCreatePhoneNumber() {
    assertThat(createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}))
        .isEqualTo("(123) 456-7890");
  }

  @Test
  void shouldCreatePhoneNumberWithArray() {
    assertThat(createPhoneNumberWithArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}))
        .isEqualTo("(123) 456-7890");
  }

  private String createPhoneNumber(int[] arr) {
    return String.format("(%d%d%d) %d%d%d-%d%d%d%d",
        arr[0], arr[1], arr[2],
        arr[3], arr[4], arr[5],
        arr[6], arr[7], arr[8], arr[9]
    );
  }

  private String createPhoneNumberWithArray(int[] arr) {
    return String.format("(%d%d%d) %d%d%d-%d%d%d%d",
        Arrays.stream(arr)
            .boxed()
            .toArray()
    );
  }
}
