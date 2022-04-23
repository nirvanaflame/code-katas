package codewars.two.april;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class IsLongPressedName {

    public static void main(String[] args) {

        boolean longPressedName = isLongPressedName("saeed", "ssaaedd");
        // boolean longPressedName = isLongPressedName("a", "b");
        System.out.println(longPressedName);

    }

    public static boolean isLongPressedName(String name, String typed) {
        List<String> nl = Arrays.stream(name.split("")).toList();
        ArrayDeque<String> tl = new ArrayDeque<>(Arrays.stream(typed.split("")).toList());

        int matches = 0;
        for (String n : nl) {

            String t = tl.isEmpty() ? "break" : tl.pop();

            if (t.equals("break")) {
                break;
            }

            while (!n.equals(t)) {
                if (tl.isEmpty()) break;
                t = tl.pop();
            }
            matches++;
        }

        return matches == name.length();
    }
}
