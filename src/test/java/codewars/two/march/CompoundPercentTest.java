package codewars.two.march;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompoundPercentTest {

    @Test
    void findCompoundPercent() {
        assertEquals(3778, findCompoundPercent(365));
    }

    private int findCompoundPercent(int days) {
        double base = 100;
        for (int i = 0; i < days; i++) {
            base += (base * 0.01);
        }
        return (int) base;
    }
}
