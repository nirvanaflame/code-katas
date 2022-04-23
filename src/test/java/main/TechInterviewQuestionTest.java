package main;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TechInterviewQuestionTest {
    @Test
    @Disabled
    void test() {
        String str = """
                The key benefit of an array data structure is that it offers fast O(1) search if you know the index
                but adding and removing an element from an array is slow because you cannot change the size of the array once it’s created.
                """;
        System.out.println(formatText(str, 20));
    }

    String formatText(String text, int width) {
        String[] words = text.split(" ");

        List<String> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        int counter = words[0].length();
        for (int i = 1; i < words.length; i++) {
            counter += words[i].length();
            if (counter <= width) {
                list.add(words[i]);
            } else {
                counter = 0;
                sb.append(addSpaces(list, width));
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    String addSpaces(List<String> list, int width) {

        return null;
    }
}
