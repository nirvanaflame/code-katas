package codewars.two.april;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class TuringTest {

    public static void main(String[] args) {
        String a = "abbcd";
        String b = "dcbeba";
        unique(a, b);

        int[] rotate = rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.println(Arrays.toString(rotate));

        int[] rotate2 = rotate2(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.println(Arrays.toString(rotate2));

        int[] shiftArr = shiftArr(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.println(Arrays.toString(shiftArr));

    }

    public static void unique(String a, String b) {
        HashSet<Character> unique = new HashSet<>();
        HashSet<Character> common = new HashSet<>();

        for (Character c : a.toCharArray()) {
            unique.add(c);
        }

        for (Character c : b.toCharArray()) {
            if (!unique.add(c)) {
                common.add(c);
            }
        }

        unique.removeAll(common);
        System.out.println(unique);
    }

    public static int[] rotate(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length];

        int index = 0;
        System.out.println(index);
        int r = length - k;
        for (int i = r; i < length; i++) {
            int val = nums[i];
            result[index] = val;
            index++;
        }

        System.out.println(index);

        for (int i = 0; i < r; i++) {
            result[index] = nums[i];
            index++;
        }

        return result;
    }

    public static int[] rotate2(int[] nums, int k) {

        int length = nums.length;
        int start = length - k;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = start; i < length; i++) {
            list.add(nums[i]);
        }

        for (int i = 0; i < start; i++) {
            list.add(nums[i]);
        }


        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] shiftArr(int[] inArr, int shift) {
        while (shift > 0) {
            int lastVar = inArr[inArr.length - 1];
            for (int counter = 0; counter < inArr.length; counter++) {
                int curVal = inArr[counter];
                inArr[counter] = lastVar;
                lastVar = curVal;
            }
            shift--;
        }
        return inArr;
    }

    @Test
    void returnTrueForValidParenthesis() {
        String sad = "([]){}";
        char[] chars = sad.toCharArray();

        assertTrue(isValid(chars));

    }

    boolean isValid(char[] chars) {
        LinkedList<Character> list = new LinkedList<>();
        for (char sym : chars) {
            switch (sym) {
                case '{', '[', '(' -> list.add(sym);
                case '}', ']', ')' -> {
                    if (!isClosed(list.removeLast(), sym)) return false;
                }
            }
        }
        return list.isEmpty();
    }

    boolean isClosed(char prev, char sym) {
        return switch (prev) {
            case '(' -> sym == ')';
            case '[' -> sym == ']';
            case '{' -> sym == '}';
            default -> false;
        };
    }

    @Test
    void testPattern() {
        boolean isValid = validParentheses(")(())");

        assertFalse(isValid);
    }

    @Test
    void testPatterns() {
        boolean isValid = validParentheses("(p{}p[])");

        assertTrue(isValid);
    }

    boolean validParentheses(String parens) {
        try {
            Pattern.compile(parens.replaceAll("[^()]", ""));
            return true;
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    @Test
    @Disabled("not implemented")
    void returnValidCallPoint(){
        String[] ops = {"5", "2", "C", "D", "+"};
        Arrays.sort(ops);
        assertEquals(27, callPoint(ops));
    }

    int callPoint(String[] ops) {
        int total = 0;
        int prev = 0;
        for (String op : ops) {
            if (Character.isDigit(op.toCharArray()[0])) {
                Integer value = Integer.getInteger(op);
                prev = value;
                total += value;
            } else if (op.equals("C")) {
                prev = total;
                total -= prev;
            } else if (op.equals("D")) {
                prev = total;
                total *= 2;
            } else if (op.equals("+")) {

            }
        }
        return 0;
    }

}

