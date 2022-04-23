package codewars.one.may;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfOddNumbersTest {

  @Test
  void shouldReturnSumOfOddNumbersInARow() {
    assertThat(sumRowOddNumbers(1)).isEqualTo(1);
    assertThat(sumRowOddNumbers(2)).isEqualTo(8);
    assertThat(sumRowOddNumbers(3)).isEqualTo(27);
    assertThat(sumRowOddNumbers(42)).isEqualTo(74088);
  }

  @Test
  void testKataBestSolution() {
    assertThat(bestSolution(1)).isEqualTo(1);
    assertThat(bestSolution(2)).isEqualTo(8);
    assertThat(bestSolution(3)).isEqualTo(27);
    assertThat(bestSolution(42)).isEqualTo(74088);
  }

  /*
   *  1
   *  3     5
   *  7     9    11
   *  13    15    17    19
   *  21    23    25    27    29
   * */
  private int sumRowOddNumbers(int n) {
    int[] oddRow = generateOddRow(n);

    return Arrays.stream(oddRow).sum();
  }

  private int[] generateOddRow(int n) {
    int[][] matrix = new int[n][n];
    int odd = 1;
    for (int row = 0; row < n; row++) {

      for (int col = 0; col <= row; col++) {
        matrix[row][col] = odd;
        odd += 2;
      }
      System.out.println(Arrays.toString(matrix[row]));
    }

    return matrix[n - 1];
  }

  /* sum of consequent M numbers is (M+1)M/2, so
  * we may know how many numbers were below
  * our ROW : numbersBelow = ((n-1)*(n))/2.
  * Now we may calculate first number in row:
  * firstNumberInRow = 2*numbersBelow+1.
  * So, firstNumberInRow = n*n-n+1 and
  * last number in ROW is n*n-n+1 + 2(n-1).
  * Let assume that last number before row is
  * x1 and last number in row is x2. It's known
  * that 1+3+5+...+(2k-1) = k*k.
  * Sum in row must be x2*x2 - x1*x1.
  // OUR x1 = (n*n-n)/2 and x2 = (n*n+n)/2.
  * After some simplification: SUM = n*n*n. */
  private int bestSolution(int n) {
    return n * n * n;
  }
}
