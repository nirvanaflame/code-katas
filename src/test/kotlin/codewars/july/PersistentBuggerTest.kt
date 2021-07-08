package codewars.july

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PersistentBuggerTest {

    @Test
    fun `should return multiplicative persistence for one digits number`() {
        assertEquals(0, persistence(3))
    }

    @Test
    fun `should return multiplicative persistence for two digits number`() {
        assertEquals(3, persistence(39))
    }

    @Test
    fun `should return multiplicative persistence for three digits number`() {
        assertEquals(4, persistence(999))
    }

    @Test
    fun `codewars best solution`() {
        assertEquals(1, persistenceClever(3))
        assertEquals(4, persistenceClever(999))
    }

    /**
     * Write a function, persistence, that takes in a positive parameter num
     * and returns its multiplicative persistence,
     * which is the number of times you must multiply the digits in num
     * until you reach a single digit.
     *
     * For example:
     * persistence(39) == 3 // because 3*9 = 27, 2*7 = 14, 1*4=4
     *                         and 4 has only one digit
     * persistence(999) == 4 // because 9*9*9 = 729, 7*2*9 = 126,
     *                         1*2*6 = 12, and finally 1*2 = 2
     * persistence(4) == 0 // because 4 is already a one-digit number
     */
    private fun persistence(n: Int): Int {
        var count = 0
        var number = n
        if (n == 0) return count
        while (number > 9) {
            count++
            println(number)
            number = number.toString()
                .split("")
                .filter(String::isNotBlank)
                .map { it.toInt() }
                .reduce { acc, each -> acc * each }
        }

        return count
    }

    private fun persistenceClever(num: Int) =
            generateSequence(num) {
                it.toString().map(Character::getNumericValue).reduce { acc, i -> acc * i }
            }.takeWhile { it > 9 }.count()
}
