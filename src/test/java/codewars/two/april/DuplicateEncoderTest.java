package codewars.two.april;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicateEncoderTest {

    @Test
    void testDuplicateEncoder() {
        assertEquals("))))())))", encode("   ()(   "));
    }

    @Test
    void testDuplicateEncoderSuccess() {
        assertEquals(")())())", encode("Success"));
    }

    @Test
    void testDuplicateEncoderExample() {
        assertEquals("(((", encode("din"));
        assertEquals("()()()", encode("recede"));
        assertEquals("))((", encode("(( @"));
    }


    private String encode(String str) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        String[] split = str.toLowerCase().split("");
        for (String s : split) {
            map.merge(s, 1, Integer::sum);
        }

        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if (map.get(s) == 1) sb.append("(");
            else sb.append(")");
        }

        return sb.toString();
    }
}
