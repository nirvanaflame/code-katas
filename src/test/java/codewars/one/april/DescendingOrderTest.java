package codewars.one.april;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class DescendingOrderTest {

  @Test
  void shouldSortDescSimple() {
    assertThat(sortDesc(123456)).isEqualTo(654321);
  }

  @Test
  void shouldSortDescWithDuplicates() {
    assertThat(sortDesc(45561265)).isEqualTo(66555421);
  }

  private int sortDesc(int num) {
    return Integer.parseInt(
        String.valueOf(num).chars()
            .map(Character::getNumericValue)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining())
    );
  }


  @Test
  void shouldSortDescCleverSimple() {
    assertThat(cleverSolution(123456)).isEqualTo(654321);
  }

  @Test
  void shouldSortDescCleverDuplicates() {
    assertThat(cleverSolution(45561265)).isEqualTo(66555421);
  }

  private int cleverSolution(int num) {
    return Integer.parseInt(
        String.valueOf(num).chars()
            .mapToObj(it -> String.valueOf(Character.getNumericValue(it)))
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.joining())
    );
  }
}
