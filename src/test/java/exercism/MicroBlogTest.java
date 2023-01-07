package exercism;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MicroBlogTest {

    @Test void test() {
        assertThat(truncate("🃎🂸🃅🃋🃍🃁🃊")).isEqualTo("🃎🂸🃅🃋🃍");
    }

    String truncate(String s) {
        int maxLength = 5;

        var length = s.codePointCount(0, s.length());
        var endIndex = s.offsetByCodePoints(0, Math.min(length, maxLength));

        return s.substring(0, endIndex);
    }
}
