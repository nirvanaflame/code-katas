package codewars.two.may;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TribinacciSequenceTest {

  @Test
  void sampleTests() {
    double precision = 1e-10;
    assertArrayEquals(new double []{1,1,1,3,5,9,17,31,57,105}, tribonacci(new double []{1,1,1},10), precision);
    assertArrayEquals(new double []{0,0,1,1,2,4,7,13,24,44}, tribonacci(new double []{0,0,1},10), precision);
    assertArrayEquals(new double []{0,1,1,2,4,7,13,24,44,81}, tribonacci(new double []{0,1,1},10), precision);
  }

  @Test
  void sampleXTests() {
    double precision = 1e-10;
    assertArrayEquals(new double []{1,1,1,3,5,9,17,31,57,105}, xbonacci(new double []{1,1,1},10), precision);
    assertArrayEquals(new double []{0,0,1,1,2,4,7,13,24,44}, xbonacci(new double []{0,0,1},10), precision);
    assertArrayEquals(new double []{0,1,1,2,4,7,13,24,44,81}, xbonacci(new double []{0,1,1},10), precision);
  }

  double[] tribonacci(double[] s, int n) {
    if (n == 0) return new double[]{};

    ArrayList<Double> list = new ArrayList<>() {{
      add(0, s[0]);
      add(1, s[1]);
      add(2, s[2]);
    }};

    for (int i = 3; i < n; i++) {
      double value = list.get(i - 3) + list.get(i - 2) + list.get(i - 1);
      list.add(value);
    }

    return list.stream().mapToDouble(Double::doubleValue).limit(n).toArray();
  }

  double[] xbonacci(double[] s, int n) {
    double[] r = Arrays.copyOf(s, n);
    for (int i = 3; i < n; i++) {
      r[i] = r[i-3] + r[i-2] + r[i-1];
    }
    return r;
  }
}
