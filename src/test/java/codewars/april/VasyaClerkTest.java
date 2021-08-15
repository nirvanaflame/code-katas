package codewars.april;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class VasyaClerkTest {

  int bill25 = 0;
  int bill50 = 0;

  @Test
  void couldExchangeYes() {
    assertThat(canSellTickets(new int[]{25, 25, 50})).isEqualTo("YES");
    assertThat(canSellTickets(new int[]{25, 25, 50, 100})).isEqualTo("YES");
    assertThat(canSellTickets(new int[]{25, 25, 25, 25, 50, 100, 50})).isEqualTo("YES");
  }

  @Test
  void couldExchangeNo() {
    assertThat(
        canSellTickets(new int[]{25, 25, 25, 25, 25, 25, 25, 50, 50, 50, 100, 100, 100, 100}))
        .isEqualTo("NO");
  }

  private String canSellTickets(int[] tickets) {
    for (int ticket : tickets) {
      exchange(ticket);
      if (bill25 < 0 || bill50 < 0) {
        return "NO";
      }
    }
    return "YES";
  }

  private void exchange(int payment) {
    if (payment == 25) {
      bill25++;
    } else {
      changeBills(payment);
    }
  }

  private void changeBills(int payment) {
    if (payment == 50) {
      bill25--;
      bill50++;
    } else {
      bill25--;
      bill50--;
    }
  }
}
