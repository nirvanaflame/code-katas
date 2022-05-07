package codewars.two.may;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled("сложна")
class PhoneNumbersTest {

  static HashMap<String, List<String>> graph = new HashMap<>() ;

  @Test
  void shouldReturnPhoneNumber() {
    assertEquals(31, phoneNumberGraph("0123456789 0123987654 0123987456 2365498756 2365498765"));
  }

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
}
