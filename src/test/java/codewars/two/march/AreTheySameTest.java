package codewars.two.march;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/*
 * Given two arrays a and b write a function comp(a, b) (orcompSame(a, b)) that checks whether the two arrays have
 * the "same" elements, with the same multiplicities (the multiplicity of a member is the number of times it appears).
 * "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.*/
public class AreTheySameTest {

    @Test
    void areSame() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};

        assertTrue(comp(a, b));
    }

    @Test
    void notSame() {
        int[] a = new int[]{2, 2, 3};
        int[] b = new int[]{4, 9, 9};

        assertFalse(comp(a, b));
    }

    @Test
    void notSameInvalidInput() {
        int[] a = new int[]{};
        int[] b = null;

        assertFalse(comp(a, b));
    }


    boolean comp(int[] a, int[] b) {
        if (a == null || b == null) return false;

        return Arrays.equals(
                Arrays.stream(a).map(it -> it * it).sorted().toArray(),
                Arrays.stream(b).sorted().toArray()
        );
    }
}
