package codewars.two.may;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled("сложна")
class PhoneNumbersTest {

    static HashMap<String, List<String>> graph = new HashMap<>();

    @Test
    void shouldReturnPhoneNumber() {
        assertEquals(31, phoneNumberGraph("0123456789 0123987654 0123987456 2365498756 2365498765"));
    }

    int phoneNumberGraph(String str) {
        String[] nums = str.split(" ");
        String first = initFirstBucket(nums);

        for(String num : nums) {
            if(num.equals(first)) continue;

            String bucket = findOrCreate(num);

            String[] split = num.split("");
            for(int i = 0; i < split.length; i++) {
                LinkedList<String> list = (LinkedList<String>) graph.get(bucket);
                String v = split[i];
                if(list.get(i).equals(v)) continue;
                else graph.get(bucket).add(v);
            }

        }
        return (int) graph.values().stream().mapToLong(Collection::size).sum();
    }

    @NotNull
    String findOrCreate(String num) {
        String bucket = num.substring(0, 1);
        graph.computeIfAbsent(bucket, s -> new LinkedList<>());
        return bucket;
    }

    @NotNull
    String initFirstBucket(String[] nums) {
        String first = nums[0];
        List<String> fList = graph.computeIfAbsent(first.substring(0, 1), s -> new LinkedList<>());
        fList.addAll(Arrays.asList(first.split("")));
        return first;
    }

    @Nested @DisplayName("ChatGPT solution")
    class ChatGPT {

        int phoneNumberGraph(String str) {
            String[] nums = str.split(" ");
            String first = initFirstBucket(nums);

            for (String num : nums) {
                if (num.equals(first)) continue;

                String bucket = findOrCreate(num);

                String[] split = num.split("");
                for (int i = 0; i < split.length; i++ ) {
                    LinkedList<String> list = (LinkedList<String>) graph.get(bucket);
                    String v = split[i];
                    if (list.get(i).equals(v)) continue;
                    else list.add(v);
                }

            }
            return (int) graph.values().stream().mapToLong(Collection::size).sum();
        }

        @NotNull
        String findOrCreate(String num) {
            String bucket = num.substring(0, 1);
            graph.computeIfAbsent(bucket, s -> new LinkedList<>());
            return bucket;
        }

        @NotNull
        String initFirstBucket(String[] nums) {
            String first = nums[0];
            List<String> fList = graph.computeIfAbsent(first.substring(0, 1), s -> new LinkedList<>());
            fList.addAll(Arrays.asList(first.split("")));
            return first;
        }


        @ParameterizedTest
        @MethodSource("phoneNumberGraphTestCases")
        void shouldReturnPhoneNumber(int expected, String str) {
            assertEquals(expected, phoneNumberGraph(str));
        }

        static Stream<Arguments> phoneNumberGraphTestCases() {
            return Stream.of(
                    Arguments.of(31, "0123456789 0123987654 0123987456 2365498756 2365498765"),
                    Arguments.of(31, "0123456789 0123987654 0123987456 2365498756 2365498765"),
                    Arguments.of(10, "0123456789"),
                    Arguments.of(9, "123456789"),
                    Arguments.of(10, "9876543210"),
                    Arguments.of(9, "987654321")
            );
        }
    }

}