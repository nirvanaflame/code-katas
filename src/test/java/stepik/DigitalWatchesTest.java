package stepik;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class DigitalWatchesTest {

  @Test
  void shouldReturnTime() {
    assertThat(time(3602)).isEqualTo("1:00:02");
  }

  @Test
  void testVeryBigHours() {
    assertThat(time(5313602)).isEqualTo("12:00:02");
  }

  private String time(int n) {

    int h = n / 3600;
    n -= h * 3600;
    int m = n / 60;
    int s = n % 60;

    if (h > 23) {
      h %= 24;
    }

    LocalTime time = LocalTime.of(h, m, s);
    return String.format("%tk:%tM:%tS", time, time, time);
  }
}
