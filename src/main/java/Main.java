import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
public static void main(String[] args){

    System.out.println(digitize(new long[]{123, 12 ,123}));
}

  public static List<Long> digitize(long[] n) {
    HashMap<Long, Long> map = new HashMap<>();
    return Arrays.stream(n)
        .boxed()
        .map(it -> {map.merge(it, 1L, Long::sum);
          return it;
        })
        .collect(Collectors.toList());
  }
}
