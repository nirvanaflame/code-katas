package codewars.two.may;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {

  @Test
  void shouldSortArray() {
    assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6}, quickSortArray(new int[] {3, 2, 5, 6, 1, 4}));
  }

  int[] quickSortArray(int[] a) {
    return quickSort0(a).toArray();
  }

  IntStream quickSort0(int[] a) {
    if (a.length < 2) return IntStream.of(a);
    int pivot = a[a.length / 2]; // recursive case

    IntStream less = Arrays.stream(a).filter(it -> it < pivot);
    IntStream greater = Arrays.stream(a).filter(it -> it > pivot);

    return IntStream.concat(
        IntStream.concat(quickSort0(less.toArray()), IntStream.of(pivot)),
        quickSort0(greater.toArray()));
  }
}
