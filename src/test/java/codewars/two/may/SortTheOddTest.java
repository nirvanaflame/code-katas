package codewars.two.may;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTheOddTest {


  @Test
  void exampleTest1() {
    assertArrayEquals(new int[]{ 1, 3, 2, 8, 5, 4 }, sortArray(new int[]{ 5, 3, 2, 8, 1, 4 }));
  }


  @Test
  void exampleTest2() {
    assertArrayEquals(new int[]{ 1, 3, 5, 8, 0 }, sortArray(new int[]{ 5, 3, 1, 8, 0 }));
  }

  @Test
  void exampleTest3() {
    assertArrayEquals(new int[]{}, sortArray(new int[]{}));
  }


  int[] sortArray(int[] a) {
    int[] odds = Arrays.stream(a).filter(it -> it % 2 == 1).sorted().toArray();

    for (int i =0, j = 0; i < a.length; i++)
      a[i] = a[i] % 2 == 0 ? a[i] : odds[j++];

    return a;
  }
}
