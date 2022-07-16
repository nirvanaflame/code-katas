package codewars.june

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTheDigitTest {

    @Test
    fun shouldCountDigits() {
        assertEquals(4, nbDig(10, 1))
        assertEquals(1, nbDig(3, 4))
    }

    @Test
    fun shouldCountDigitsFunctionally() {
        assertEquals(11, countDigitFunction(25, 1))
    }

    private fun nbDig(n: Int, d: Int): Int {
        var count = 0
        for (i in 0..n) {
            val k = i * i
            count += k.toString().count { Character.getNumericValue(it) == d }
        }
        return count
    }

    private fun countDigitFunction(n: Int, d: Int) =
            (0..n).map { it * it }
                .sumOf {
                    it.toString()
                        .count { c: Char ->
                            Character.getNumericValue(c) == d
                        }
                }
}


