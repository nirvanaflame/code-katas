package educative.interveiwpatterns;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SlidingWindowTest {

    @Nested @DisplayName("Find Maximum in Sliding Window") class MaximumInSlidingWindow {
        public static ArrayDeque<Integer> findMaxSlidingWindow(List<Integer> nums, int windowSize) {
            if(windowSize > nums.size()) windowSize = nums.size();

            ArrayDeque<Integer> result = new ArrayDeque<>();
            for(int i = windowSize; i <= nums.size(); i++) {
                int start = i - windowSize;
                int max = nums.get(start);
                for(int j = start; j < i; j++) {
                    max = Math.max(max, nums.get(j));
                }
                result.add(max);
            }

            return result;
        }

        public static ArrayDeque<Integer> findMaxMoreReadableSolution(List<Integer> nums, int windowSize) {
            if(windowSize > nums.size()) windowSize = nums.size();

            var result = new ArrayDeque<Integer>();
            for(int i = 0; i < nums.size(); i++) {
                var toIndex = i + windowSize;
                if(toIndex > nums.size()) break;
                int max = findMax(nums.subList(i, toIndex));
                result.add(max);
            }

            return result;
        }

        @NotNull private static Integer findMax(List<Integer> nums) {
            return nums.stream().max(Comparator.naturalOrder()).get();
        }

        public static ArrayDeque<Integer> getMax(List<Integer> data, int windowSize) {
            int[] maxValues = new int[data.size() - windowSize + 1];
            var res = new ArrayDeque<Integer>();
            LinkedList<Integer> deque = new LinkedList<>();
            for(int i = 0; i < data.size(); i++) {
                // Remove elements that are out of the current window
                while(!deque.isEmpty() && deque.peek() < i - windowSize + 1) {
                    deque.poll();
                }
                // Remove elements that are smaller than the current element
                while(!deque.isEmpty() && data.get(deque.peekLast()) < data.get(i)) {
                    deque.pollLast();
                }
                // Add the current element
                deque.offer(i);
                // Add the maximum element to the result array if we have reached the end of a window
                if(i >= windowSize - 1) {
                    res.add(data.get(deque.peek()));
                }
            }
            return res;
        }

        public static ArrayDeque<Integer> chatGPT(List<Integer> nums, int windowSize) {
            if(nums == null || nums.isEmpty()) {
                return new ArrayDeque<>();
            }
            if(windowSize > nums.size()) {
                windowSize = nums.size();
            }
            if(windowSize <= 0) {
                return new ArrayDeque<>();
            }

            ArrayDeque<Integer> result = new ArrayDeque<>();
            List<Integer> mutableNums = new ArrayList<>(nums);
            for(int i = 0; i < mutableNums.size() - windowSize + 1; i++) {
                int max = Integer.MIN_VALUE;
                for(int j = i; j < i + windowSize; j++) {
                    max = Math.max(max, mutableNums.get(j));
                }
                result.add(max);
            }

            return result;
        }


        @Test void checkFindMaxSlidingWindow() {
            var res = findMaxSlidingWindow(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3);
            assertThat(res).containsExactly(3, 4, 5, 6, 7, 8, 9, 10);
        }

        @Test void checkFindMaxSlidingWindowWithNegatives() {
            var res = findMaxSlidingWindow(List.of(1, 2, -3, 4, 0, 6, -7, 8, 9, 10), 3);
            assertThat(res).containsExactly(2, 4, 4, 6, 6, 8, 9, 10);
        }


        @Test void checkFindMaxSlidingWindowWithSuperBigWindow() {
            var res = findMaxSlidingWindow(List.of(1, 2, -3, 4, 0, 6, -7, 8, 9, 10), 20);
            assertThat(res).containsExactly(10);
        }

        @Test void checkFindMaxSlidingWindowWithNegativesBetter() {
            var res = findMaxMoreReadableSolution(List.of(1, 2, -3, 4, 0, 6, -7, 8, 9, 10), 3);
            assertThat(res).containsExactly(2, 4, 4, 6, 6, 8, 9, 10);
        }

        @Test void checkFindMaxBetterSpecialCase() {
            var res = findMaxMoreReadableSolution(List.of(1, 2, -3, 4, 0, 3, -7, 8, 9, 10), 3);
            assertThat(res).containsExactly(2, 4, 4, 4, 3, 8, 9, 10);
        }

        @Test void checkGetMax() {
            var res = getMax(List.of(1, 2, -3, 4, 0, 3, -7, 8, 9, 10), 3);
            assertThat(res).containsExactly(2, 4, 4, 4, 3, 8, 9, 10);
        }

        @Test void checkChatGPT() {
            var res = chatGPT(List.of(1, 2, -3, 4, 0, 3, -7, 8, 9, 10), 3);
            assertThat(res).containsExactly(2, 4, 4, 4, 3, 8, 9, 10);
        }
    }

    @Nested @DisplayName("Find Minimum Window Subsequence") class MinimumWindowSubsequence {

        @NotNull @Contract(pure = true) public static String minWindow(final String s, final String t) {
            int bestStart = 0, bestEnd = s.length() - 1;
            int indexStart, indexT, indexLastMatch;
            indexStart = indexT = indexLastMatch = 0;

            while(s.length() - indexStart > t.length()) {
                indexStart = findStart(s, t, indexStart, indexT);

                if(indexStart == bestEnd) break;

                indexLastMatch = 0;
                indexT = 1;
                for(int i = indexStart + 1; i < s.length(); i++) {
                    if(s.charAt(i) == t.charAt(indexT)) {
                        indexT++;
                        if(indexT == t.length()) {
                            indexLastMatch = i;
                            break;
                        }
                    }
                }
                if(isInvalid(indexStart, indexLastMatch)) return "";
                if(indexStart > indexLastMatch) continue;

                if(bestEnd - bestStart > indexLastMatch - indexStart) {
                    bestEnd = indexLastMatch;
                    bestStart = indexStart;
                }

                indexStart++;
                indexT = 0;

            }
            if(isInvalid(indexStart, indexLastMatch)) return "";

            System.out.printf("start: %d, end:%d", bestStart, bestEnd);

            return s.substring(bestStart, bestEnd + 1);
        }

        private static int findStart(String s, String t, int indexS, int indexT) {
            while(indexS < s.length() && s.charAt(indexS) != t.charAt(indexT)) {
                indexS++;
            }
            return indexS;
        }

        private static boolean isInvalid(int indexStart, int indexLastMatch) {
            return indexStart == 0 && indexLastMatch == 0;
        }

        @Test void findMinimumWindowSequence() {
            var res = minWindow("abcdebdde", "bde");

            assertThat(res).isEqualTo("bcde");
        }

        @Test void findMinimumWindowSequenceFirstAndLast() {
            var res = minWindow("afgegrwgwga", "aa");

            assertThat(res).isEqualTo("afgegrwgwga");
        }

        @Test void findMinimumWindowSequenceAllotOfRepeats() {
            var res = minWindow("abababa", "ba");

            assertThat(res).isEqualTo("ba");
        }

        @Test void findMinimumWindowSequenceVeryLongString() {
            var res = minWindow("michmdznaitnjdnjkdsnmichmznait", "michmznait");

            assertThat(res).isEqualTo("michmznait");
        }

        @Test void findMinimumWindowSequenceOneMoreLongString() {
            var res = minWindow("fgrqsqsnodwmxzkzxwqegkndaa", "kzed");

            assertThat(res).isEqualTo("kzxwqegknd");
        }
    }

    @Nested @DisplayName("Repeated DNA Sequences") class RepeatedDNASequences {

        public static List<String> findRepeatedSequences(String str, int k) {
            var result = new HashSet<String>();

            var hash = new HashSet<Integer>();
            for(int i = 0; i < str.length() - k; i++) {
                int end = i + k;
                var substring = str.substring(i, end);
                if(!hash.add(substring.hashCode())) {
                    result.add(substring);
                }
            }

            return new ArrayList<>(result);
        }

        public static List<String> findRepeatedSequencesChatGPT(String str, int k) {
            // Create a Map to store substrings and their occurrences
            Map<String, Integer> map = new HashMap<>();
            // Create a List to store the repeated substrings
            List<String> repeated = new ArrayList<>();

            // Iterate through the string, extracting substrings of length k
            for(int i = 0; i <= str.length() - k; i++) {
                String substring = str.substring(i, i + k);
                // If the Map contains the substring, increment its count
                if(map.containsKey(substring)) {
                    map.put(substring, map.get(substring) + 1);
                    // If the count is greater than 1, add the substring to the list
                    if(map.get(substring) > 1) {
                        repeated.add(substring);
                    }
                } else {
                    // If the Map does not contain the substring, add it with count 1
                    map.put(substring, 1);
                }
            }

            return repeated;
        }

        @ParameterizedTest
        @MethodSource("findRepeatedSequencesTestCasesChat")
        void testFindRepeatedSequencesChat(String str, int k, List<String> expected) {
            assertThat(findRepeatedSequencesChatGPT(str, k)).containsSequence(expected);
        }

        static Stream<Arguments> findRepeatedSequencesTestCasesChat() {
            return Stream.of(
                Arguments.of("AAAACCCCTAAAACCCCC", 8, List.of("AAAACCCC")),
                Arguments.of("GGGGGGGGGGGGGGGGGGGGGGGGG", 12, List.of("GGGGGGGGGGGG")),
                Arguments.of("AAAAACCCCCAAAAACCCCCC", 8, List.of("AAAAACCC", "AAACCCCC", "AAAACCCC")),
                Arguments.of("ATATATATATATATAT", 6, List.of("ATATAT", "TATATA"))
            );
        }

        @ParameterizedTest
        @MethodSource("findRepeatedSequencesTestCases")
        void testFindRepeatedSequences(String str, int k, List<String> expected) {
            assertThat(findRepeatedSequences(str, k)).containsSequence(expected);
        }

        static Stream<Arguments> findRepeatedSequencesTestCases() {
            return Stream.of(
                Arguments.of("AAAACCCCTAAAACCCCC", 8, List.of("AAAACCCC")),
                Arguments.of("GGGGGGGGGGGGGGGGGGGGGGGGG", 12, List.of("GGGGGGGGGGGG")),
                Arguments.of("AAAAACCCCCAAAAACCCCCC", 8, List.of("AAAAACCC", "AAACCCCC", "AAAACCCC")),
                Arguments.of("ATATATATATATATAT", 6, List.of("ATATAT", "TATATA"))
            );
        }

    }

    @Nested @DisplayName("Minimum Window Substring") class MinimumWindowsSubstring {

        @Test void checkMinWindow() {
            assertThat(minWindow("ABDOEDECOBE", "BC")).isEqualTo("COB");
            assertThat(minWindow("DFFDFDFDVD", "VDD")).isEqualTo("DVD");
        }

        String minWindow(String s, String t) {
            if(Objects.equals(t, "")) {
                return "";
            }

            var rCount = new HashMap<Character, Integer>();
            for(var c : t.toCharArray()) {
                rCount.put(c, rCount.getOrDefault(c, 0) + 1);
            }

            int l = 0;
            int r = 0;
            int current = 0;
            int required = rCount.size();
            int resLen = Integer.MAX_VALUE;
            int start = 0;

            var window = new HashMap<Character, Integer>();
            while(r < s.length()) {
                char c = s.charAt(r++);

                // Populating the window hashmap
                if(rCount.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);

                    if(window.get(c).equals(rCount.get(c))) {
                        current++;
                    }
                }

                // Adjusting the sliding window
                while(current == required) {
                    // update our result
                    if(r - l < resLen) {
                        start = l;
                        resLen = r - l;
                    }

                    char d = s.charAt(l++);

                    if(rCount.containsKey(d)) {
                        if(window.get(d).equals(rCount.get(d))) {
                            current--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }

            return resLen == Integer.MAX_VALUE ? "" : s.substring(start, start + resLen);
        }


        @Test void checkMinWindow2() {
            assertThat(minWindow("ABDOEDECOBE", "BC")).isEqualTo("COB");
            assertThat(minWindow2("DFFDFDFDVD", "VDD")).isEqualTo("DVD");
        }

        String minWindow2(String s, String t) {
            if(t.isBlank()) {
                return "";
            }

            var rCount = new HashMap<Character, Integer>();
            var window = new HashMap<Character, Integer>();

            for(char c : t.toCharArray()) {
                rCount.put(c, rCount.getOrDefault(c, 0) + 1);
            }

            int r, l, resLen = Integer.MAX_VALUE, start, current;
            r = l = start = current = 0;
            var required = rCount.size();


            while(r < s.length()) {
                var c = s.charAt(r++);

                if(rCount.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);

                    if(window.get(c).equals(rCount.get(c))) {
                        current++;
                    }
                }

                while(current == required) {
                    if(r - l < resLen) {
                        start = l;
                        resLen = r - l;
                    }

                    var d = s.charAt(l++);

                    if(rCount.containsKey(d)) {
                        if(window.get(d).equals(rCount.get(d))) {
                            current--;
                        }

                        window.put(d, window.get(d) - 1);
                    }
                }
            }


            return resLen == Integer.MAX_VALUE ? "" : s.substring(start, start + resLen);
        }
    }

    @Nested @DisplayName("Longest Substring Without Repeating Substring") class LongestWindowSubstring {

        @Test void testLongestSubstringInWindow() {
            assertThat(longestSubstring("abcdbea")).isEqualTo(5);
            assertThat(longestSubstring("pwwkew")).isEqualTo(3);
        }

        private int longestSubstring(String s) {

            int max = 0, start = 0, end = 0;
            var window = new HashMap<Character, Integer>();
            while (start < s.length() && end < s.length()) {
                var c = s.charAt(end);
                if (!window.containsKey(c)) {
                    window.put(c, 1);
                    end++;
                    max = Math.max(max, end - start);
                } else {
                    var d = s.charAt(start);
                    window.remove(d);
                    start++;
                }
            }
            return max;
        }
    }
}
