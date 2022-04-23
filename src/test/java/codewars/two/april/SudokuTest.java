package codewars.two.april;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SudokuTest {

    public static final int[][] SUDOKU = new int[][]{
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };
    public static final int[][] SUB_SQUARES = new int[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}
    };

    public static final int[][] EXAMPLE = new int[][]{
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    @Test
    void exampleTest() {
        assertTrue(check(SUDOKU));
    }

    @Test
    void exampleFalse() {
        SUDOKU[0][0]++;
        SUDOKU[1][1]++;
        SUDOKU[0][1]--;
        SUDOKU[1][0]--;

        assertFalse(check(SUDOKU));
    }

    @Test
    void exampleFalse2() {
        SUDOKU[0][0]--;
        SUDOKU[1][1]--;
        SUDOKU[0][1]++;
        SUDOKU[1][0]++;
        SUDOKU[4][4] = 0;

        assertFalse(check(SUDOKU));
    }

    @Test
    void testSubSquaresFalse() {
        assertFalse(check(SUB_SQUARES));
    }

    @Test
    void testExampleTrue() {
        assertTrue(check(EXAMPLE));
    }

    @Test
    void checkWithArray_exampleFalse() {
        SUDOKU[0][0]--;
        SUDOKU[1][1]--;
        SUDOKU[0][1]++;
        SUDOKU[1][0]++;
        SUDOKU[4][4] = 0;

        assertFalse(checkWithArray(SUDOKU));
    }

    @Test
    void checkWithArray_testSubSquaresFalse() {
        assertFalse(checkWithArray(SUB_SQUARES));
    }

    @Test
    void checkWithArray_testExampleTrue() {
        assertTrue(checkWithArray(EXAMPLE));
    }

    private boolean check(int[][] sudoku) {
        HashMap<Integer, List<Integer>> blocks = new HashMap<>();
        for (int i = 0; i < sudoku.length; i++) {

            int[] row = sudoku[i];
            int[] column = new int[9];
            for (int j = 0; j < row.length; j++) {
                column[j] = sudoku[i][j];

                int bucket = ((i / 3) * 3 + (j / 3));

                // System.out.printf("i[%d],j[%d] -> bucket[%d] <- value[%d] \n", i, j, bucket, sudoku[i][j]);
                blocks.computeIfAbsent(bucket, ArrayList::new);
                blocks.get(bucket).add(sudoku[i][j]);
            }

            if (isNotSudoku(column) || isNotSudoku(row)) return false;
        }

        for (List<Integer> block : blocks.values()) {
            int[] b = block.stream().mapToInt(Integer::intValue).toArray();
            if (isNotSudoku(b)) return false;
        }
        return true;
    }

    private boolean checkWithArray(int[][] sudoku) {
        int[][] blocks = new int[9][9];
        for (int i = 0; i < sudoku.length; i++) {

            int[] row = sudoku[i];
            int[] column = new int[9];
            for (int j = 0; j < row.length; j++) {
                column[j] = sudoku[i][j];

                int blockNum = ((i / 3) * 3 + (j / 3));
                int bucketIndex = calculateBucketIndex(blockNum, j, i);

                blocks[blockNum][bucketIndex] = sudoku[i][j];
            }

            if (isNotSudoku(column) || isNotSudoku(row)) return false;
        }

        for (int[] block : blocks)
            if (isNotSudoku(block)) return false;

        return true;
    }

    private int calculateBucketIndex(int blockNum, int rowNum, int colNum) {
        return switch (blockNum) {
            case 0 -> 3*colNum + rowNum;
            case 1, 2 -> (3*colNum) + rowNum % (3*blockNum);
            default -> (3*colNum + rowNum) % (3*blockNum);
        };
    }

    private boolean isNotSudoku(int[] array) {
        return Arrays.stream(array).distinct().sum() != 45;
    }
}
