package codewars.two.may;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

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
          0, 1, 0, 4 }
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
    for (int i = 0; i < clue.length; i++) {
      Integer[] ij = mapping.get(i).toArray(new Integer[3]);
      int height = clue[i];

      if (height == 1) {
        field[ij[0]][ij[1]] = size;
      } else if(height == size){
        // 1 increase i; -1 increase j
        int operation = ij[2];
        for(int k = 1; k <= size; k++) {
          if (operation == 1){
            int i1 = ij[0];
            if (i1 == 0){
              field[k-1][ij[1]] = k;
            } else field[1+i1-k][ij[1]] = k;
          } else {
            int j1 = ij[1];
            if (j1 == 0) {
              field[ij[0]][k-1] = k;
            } else field[ij[0]][1+j1-k] = k;
          }
        }
      }
    }
    prettyPrint(field);


    // System.out.println(Arrays.toString(clue));
    return null;
  }

  void prettyPrint(int[][] field) {
    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field[0].length; j++) {
        System.out.print(field[i][j] + " ");
      }
      System.out.println();
    }
  }

  // first = i, second = j of an array, 3 param: 1 increase i, -1 increase j
  HashMap<Integer, List<Integer>> mapping = new HashMap<>(){{
    put(0, List.of(0,0,1));
    put(15, List.of(0,0,-1));
    put(1, List.of(0,1,1));
    put(2, List.of(0,2,1));
    put(3, List.of(0,3,1));
    put(4, List.of(0,3,-1));
    put(5, List.of(1,3,-1));
    put(6, List.of(2,3,-1));
    put(7, List.of(3,3,-1));
    put(8, List.of(3,3,1));
    put(9, List.of(3,2,1));
    put(10, List.of(3,1,1));
    put(11, List.of(3,0,1));
    put(12, List.of(3,0,-1));
    put(13, List.of(2,0,-1));
    put(14, List.of(1,0,-1));
  }};

}
