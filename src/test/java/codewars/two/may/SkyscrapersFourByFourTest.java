package codewars.two.may;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static java.util.Map.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class SkyscrapersFourByFourTest {

  static int clues[][] = {
      { 2, 2, 1, 3,
          2, 2, 3, 1,
          1, 2, 2, 3,
          3, 2, 1, 3 },
        { 0, 0, 1, 2,
          0, 2, 0, 0,
          0, 3, 0, 0,
          0, 1, 0, 0 }
  };

  static int outcomes[][][] = {
      { { 1, 3, 4, 2 },
          { 4, 2, 1, 3 },
          { 3, 4, 2, 1 },
          { 2, 1, 3, 4 } },
      { { 2, 1, 4, 3 },
          { 3, 4, 1, 2 },
          { 4, 2, 3, 1 },
          { 1, 3, 2, 4 } }
  };

  @Test
  void testSolvePuzzle1 () {
    assertEquals (outcomes[0], solvePuzzle(clues[0]));
  }

  @Test
  void testSolvePuzzle2 () {
    assertEquals (outcomes[1], solvePuzzle(clues[1]));
  }

  int[][] solvePuzzle(int[] clue) {
    int size = (int) Math.sqrt(clue.length);

    int[][] field = new int[size][size];
    fillInitialValues(clue, size, field);
    prettyPrint(field);

    boolean isNotFilled = true;
    while (isNotFilled) {
      for (int clueIndex = 0; clueIndex < clue.length; clueIndex++) {
        int height = clue[clueIndex];
        switch (height) {
          case 0 -> {}
          case 1 -> {}
          case 2 -> {
            String dir = direction(clueIndex, size);
            field[3][3] = 3;
            int[] row = getRow(field, clueToIndexMap.get(clueIndex));
            int[] column = getColumn(field, clueToIndexMap.get(clueIndex));


            System.out.println(Arrays.toString(row));
            isNotFilled = false;
          }
          case 3 -> {}
        }
      }
    }


    // System.out.println(Arrays.toString(clue));
    return null;
  }

  int[] getRow(int[][] field, Entry<Integer, Integer> ip) {
    return Arrays.copyOf(field[ip.getValue()], field.length);
  }

  int[] getColumn(int[][] field, Entry<Integer, Integer> ip) {
    int[] a = new int[field.length];
    for(int i = 0; i < field.length; i++) {
      a[i] = field[i][ip.getValue()];
    }
    return a;
  }

  boolean isValid(int[] a) {
    return Arrays.stream(a).distinct().count() == a.length;
  }

  private void fillInitialValues(int[] clue, int size, int[][] field) {
    for (int clueIndex = 0; clueIndex < clue.length; clueIndex++) {
      var indexPair = clueToIndexMap.get(clueIndex);
      int height = clue[clueIndex];

      if (height == 1) {
        field[indexPair.getKey()][indexPair.getValue()] = size;
      } else if(height == size){
        String operation = direction(clueIndex, size);
        fillAll(field, size, indexPair, operation);
      }
    }
  }

  private void fillAll(int[][] field, int maxValue, Entry<Integer, Integer> indexPair, String oper) {
    switch (oper) {
      case "i++" -> {
        for (int i = indexPair.getKey(); i < maxValue; i++)
          field[i][indexPair.getValue()] = i + 1;
      }
      case "i--" -> {
        for (int i = indexPair.getKey(); i >= 0; i--)
          field[i][indexPair.getValue()] = maxValue - i;
      }
      case "j++" -> {
        for (int j = indexPair.getValue(); j < maxValue; j++)
          field[indexPair.getKey()][j] = j + 1;
      }
      case "j--" -> {
        for (int j = indexPair.getValue(); j >= 0; j--)
          field[indexPair.getKey()][j] = maxValue - j;
      }
    }
  }

  void prettyPrint(int[][] field) {
    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field[0].length; j++) {
        System.out.print(field[i][j] + " ");
      }
      System.out.println();
    }
  }

  String direction(Integer clueIndex, Integer maxValue) {
    int quarter = clueIndex / maxValue;
    return switch (quarter){
      case 0 -> "i++";
      case 1 -> "j--";
      case 2 -> "i--";
      case 3 -> "j++";
      default -> "";
    };
  }

  // first = i, second = j of an array
  HashMap<Integer, Entry<Integer, Integer>> clueToIndexMap =
      new HashMap<>() {
        {
          put(0, entry(0,0));
          put(15, entry(0, 0));
          put(1, entry(0, 1));
          put(2, entry(0, 2));
          put(3, entry(0, 3));
          put(4, entry(0, 3));
          put(5, entry(1, 3));
          put(6, entry(2, 3));
          put(7, entry(3, 3));
          put(8, entry(3, 3));
          put(9, entry(3, 2));
          put(10, entry(3, 1));
          put(11, entry(3, 0));
          put(12, entry(3, 0));
          put(13, entry(2, 0));
          put(14, entry(1, 0));
        }
      };
}
