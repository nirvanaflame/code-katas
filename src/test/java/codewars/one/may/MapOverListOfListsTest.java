package codewars.one.may;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

class MapOverListOfListsTest {

  private static final Integer[][] num = {{1, 2, 3, 4}, {5, 6, 7, 8, 9}, {0, 2, 4}};
  private static final Character[][] chr = {{'h', 'E', 'l', 'l', 'O'}, {'w', 'O', 'r', 'L', 'd'}};

  @Test
  void shouldAddOneToEach() {
    assertThat(gridMap(e -> e + 1, num))
        .isEqualTo(new Integer[][]{{2, 3, 4, 5}, {6, 7, 8, 9, 10}, {1, 3, 5}});
  }

  @Test
  void shouldMultiplyEachByTwo() {
    assertThat(gridMap(e -> e * 2, num))
        .isEqualTo(new Integer[][]{{2, 4, 6, 8}, {10, 12, 14, 16, 18}, {0, 4, 8}});
  }

  @Test
  void shouldUpperCaseEach() {
    assertThat(gridMap(Character::toUpperCase, chr))
        .isEqualTo(new Character[][]{{'H', 'E', 'L', 'L', 'O'}, {'W', 'O', 'R', 'L', 'D'}});
  }

  private <T, R> Object[][] gridMap(Function<T, R> fn, T[][] list) {
    return Arrays.stream(list)
        .map(it ->
            Arrays.stream(it)
                .map(fn)
                .toArray())
        .toArray(Object[][]::new);
  }
}
