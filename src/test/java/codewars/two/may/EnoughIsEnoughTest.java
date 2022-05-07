package codewars.two.may;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class EnoughIsEnoughTest {

  @Test
  void testDeleteNth() {
    assertArrayEquals(
        new int[] { 20, 37, 21 },
        deleteNth( new int[] { 20, 37, 20, 21 }, 1 )
    );
    assertArrayEquals(
        new int[] { 1, 1, 3, 3, 7, 2, 2, 2 },
        deleteNth( new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3 )

    );
    assertArrayEquals(
        new int[] { 1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 },
        deleteNth( new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3 )
    );
    assertArrayEquals(
        new int[] { 1, 1, 1, 1, 1 },
        deleteNth( new int[] { 1, 1, 1, 1, 1 }, 5 )
    );
    assertArrayEquals(
        new int[] { },
        deleteNth( new int[] { }, 5 )
    );

  }

  @Test
  void testDeleteNth2() {
    assertArrayEquals(
        new int[] { 20, 37, 21 },
        deleteNth2( new int[] { 20, 37, 20, 21 }, 1 )
    );
    assertArrayEquals(
        new int[] { 1, 1, 3, 3, 7, 2, 2, 2 },
        deleteNth2( new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3 )

    );
    assertArrayEquals(
        new int[] { 1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 },
        deleteNth2( new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3 )
    );
    assertArrayEquals(
        new int[] { 1, 1, 1, 1, 1 },
        deleteNth2( new int[] { 1, 1, 1, 1, 1 }, 5 )
    );
    assertArrayEquals(
        new int[] { },
        deleteNth2( new int[] { }, 5 )
    );

  }

  int[] deleteNth(int[] arr, int maxOccur) {
    System.out.println(Arrays.toString(arr));
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      if (map.get(val) == null) map.put(val, 1);
      else {
        if (map.get(val) < maxOccur) map.merge(val, 1, Integer::sum);
        else {
          arr[i] = -42;
        }
      }
    }

    return Arrays.stream(arr).filter(it -> it != -42).toArray();
  }

  int[] deleteNth2(int[] arr, int maxOccur) {
    HashMap<Integer, Integer> oqr = new HashMap<>();
    return Arrays.stream(arr).filter(it -> oqr.merge(it, 1, Integer::sum) <= maxOccur).toArray();
  }

}
