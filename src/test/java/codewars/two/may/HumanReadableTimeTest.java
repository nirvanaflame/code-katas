package codewars.two.may;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanReadableTimeTest {

  @Test
  public void Tests() {
    assertEquals("00:00:00", makeReadable(0));
    assertEquals("00:00:05", makeReadable(5));
    assertEquals("00:01:00", makeReadable(60));
    assertEquals("01:00:00", makeReadable(3600));
    assertEquals("23:59:59", makeReadable(86399));
    assertEquals( "99:59:59", makeReadable(359999));
  }

  private String makeReadable(int time) {
    int seconds, minutes, hours;
    seconds = minutes = hours = 0;
    seconds = time % 60;

    if (time < 3600) {
     minutes = Math.min((time / 60), 59);
    } else {
      int x = time / 3600;
      hours = Math.min(x, 99);
      minutes = (time-x*3600) / 60;
    }

    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
  }
}
