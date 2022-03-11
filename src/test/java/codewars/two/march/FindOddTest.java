package codewars.two.march;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
* Given an array of integers, find the one that appears an odd number of times.
* There will always be only one integer that appears an odd number of times.
* */
public class FindOddTest {

    @Test
    public void findTestFive() {
        assertEquals(5, findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
    }

    @Test
    public void findTestMinusOne() {
        assertEquals(-1, findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
    }

    @Test
    public void findTestAnotherFive() {
        assertEquals(5, findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
    }

    @Test
    public void findTestTen() {
        assertEquals(10, findIt(new int[]{10}));
    }

    @Test
    public void findTestAnotherTen() {
        assertEquals(10, findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
    }

    @Test
    public void findTestOne() {
        assertEquals(1, findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }

    private int findIt(int[] ints) {
        return Arrays.stream(ints).reduce((a, b) -> a ^ b).getAsInt();
    }
}
