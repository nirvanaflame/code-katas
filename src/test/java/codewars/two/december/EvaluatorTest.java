package codewars.two.december;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Map;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class EvaluatorTest {

    private static final Map<String, IntBinaryOperator> oper = Map.of(
        "+", (a, b) -> a + b,
        "-", (a, b) -> a - b,
        "*", (a, b) -> a * b,
        "/", (a, b) -> a / b,
        "^", (a, b) -> (int) Math.pow(a, b)
    );

    public long evaluate(String s) {

        var queue = new LinkedList<Integer>();
        for(String str : s.split(" ")) {
            var func = oper.get(str);
            if(func != null) {
                var last = queue.removeLast();
                var last2 = queue.removeLast();
                queue.addLast(func.applyAsInt(last2, last));
            } else {
                queue.addLast(Integer.parseInt(str));
            }
        }

        return queue.pop();
    }


    public long evaluateWithSwitch(String s) {

        var queue = new LinkedList<Integer>();
        for(String str : s.split(" ")) {
            queue.addLast(
                switch (str) {
                    case "+" -> queue.removeLast() + queue.removeLast();
                    case "-" -> -queue.removeLast() + queue.removeLast();
                    case "*" -> queue.removeLast() * queue.removeLast();
                    case "/" -> {
                        var last = queue.removeLast();
                        var last2 = queue.removeLast();
                        yield last2 / last;
                    }
                    default -> Integer.parseInt(str);
                });
        }

        return queue.pop();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testEvaluate(String s, int expectedResult) {
        assertThat(evaluate(s)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> testData() {
        return Stream.of(
            Arguments.of("2 3 9 4 / + *", 10),
            Arguments.of("0 3 9 4 / + *", 0),
            Arguments.of("-2 3 9 4 / + *", -10),
            Arguments.of("2 3 9 4 / + * 2 /", 5),
            Arguments.of("2", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("testData2")
    void testEvaluate2(String s, int expectedResult) {
        assertThat(evaluateWithSwitch(s)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> testData2() {
        return Stream.of(
            Arguments.of("2 3 9 4 / + *", 10),
            Arguments.of("0 3 9 4 / + *", 0),
            Arguments.of("-2 3 9 4 / + *", -10),
            Arguments.of("2 3 9 4 / + * 2 /", 5),
            Arguments.of("2", 2)
        );
    }
}
