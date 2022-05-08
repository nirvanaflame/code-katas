package codewars.two.may;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BitcoinStatisticsTest {

  @Test
  void testGetMinAvgMax() {
    int discard = 2;
    double[][] data = {{800,1200,2100,4100,1300,700}, {1000,1500,4500,5000,5800,2000,1500}};
    double[][] expect = {{2100,3100,4100}, {4500,5100,5800}, {2100,4300,5800}};
    double[][] actual = getMinAvgMax(discard , data);
    assertArrayEquals(expect, actual);
  }

  @Test
  void testGetMinAvgMax2() {
    int discard = 2;

    //data [6751.0, 3420.0, 8112.0, 4571.0, 1555.0, 7814.0, 1143.0], [341.0, 4844.0, 6272.0, 3782.0, 8896.0, 4210.0, 8683.0, 2132.0]
    double[][] data = {{6751,3420,8112,4571,1555,7814, 1143}, {341,4844,6272,3782,8896,4210,8683,2132}};
    double[][] expect = {{1555,4746,8112}, {3782,5790,8896}, {1555,5342.571428571428,8896}};
    double[][] actual = getMinAvgMax(discard , data);
    assertArrayEquals(expect, actual);
  }

  double[][] getMinAvgMax(int discard, double[][] data) {
    System.out.println(Arrays.deepToString(data));

    double[][] r = new double[data.length+1][3];
    ArrayList<Double> best = new ArrayList<>();

    int i = 0;
    for (double[] d : data) {
      DoubleSummaryStatistics stats = IntStream.rangeClosed(discard, d.length - discard - 1)
          .mapToObj(index -> d[index])
          .peek(best::add)
          .collect(Collectors.summarizingDouble(Double::doubleValue));

      r[i++] = new double[]{stats.getMin(), stats.getAverage(), stats.getMax()};
    }

    DoubleSummaryStatistics stats = best.stream().collect(Collectors.summarizingDouble(Double::doubleValue));
    r[r.length - 1] = new double[] {stats.getMin(), stats.getAverage(), stats.getMax()};

    return r;
  }
}
