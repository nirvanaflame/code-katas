package educative.netflix;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class GroupSimilarTitles {

    private static final int[] count = new int[26];

    public static Map<String, List<String>> groupTitles(String[] titles) {
        if (titles.length == 0)
            return new HashMap<>();

        Map<String, List<String>> anagrams = new HashMap<>();

        for (String title : titles) {

            System.out.println(title);
            String key = createKey(title);
            System.out.println(key);

            if (!anagrams.containsKey(key))
                anagrams.put(key, new ArrayList<>());

            anagrams.get(key).add(title);
        }

        return anagrams;
    }

    @NotNull
    private static String createKey(String str) {
        Arrays.fill(count, 0);

        for (char c : str.toCharArray()) {
            int index = c - 'a';
            count[index]++;
        }

        StringBuilder hashKey = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            hashKey.append('#');
            hashKey.append(count[i]);
        }

        return hashKey.toString();
    }

    private static List<String> searchTitle(Map<String, List<String>> gt, String query) {
        return gt.getOrDefault(createKey(query), List.of(""));
    }

    public static void main(String[] args) {
        String[] titles = {"duel", "dule", "speed", "deul", "cars"};

        Map<String, List<String>> gt = groupTitles(titles);
        String query = "spede";

        List<String> anagrams = searchTitle(gt, query);

        for (String a : anagrams) {
            System.out.println("result: " + a);
        }

    }
}
