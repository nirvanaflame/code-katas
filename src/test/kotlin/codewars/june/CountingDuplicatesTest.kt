package codewars.june

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountingDuplicatesTest {

    @Test
    fun `abcde returns zero`() {
        assertEquals(0, duplicateCount("abcde"))
        assertEquals(0, duplicateCountGroupBy("abcde"))
    }

    @Test
    fun `abcdea returns one`() {
        assertEquals(1, duplicateCount("abcdea"))
        assertEquals(1, duplicateCountGroupBy("abcdea"))
    }

    @Test
    fun `indivisibility returns one`() {
        assertEquals(1, duplicateCount("indivisibility"))
        assertEquals(1, duplicateCountGroupBy("indivisibility"))
    }

    @Test
    fun `really long string containing duplicates returns three`() {
        val text = "dA" + "c".repeat(10) + "b".repeat(100) + "a".repeat(1000)
        assertEquals(3, duplicateCount(text))
        assertEquals(3, duplicateCountGroupBy(text))
    }

    @Test
    fun `abcdeaB returns two`() {
        assertEquals(2, duplicateCount("abcdeaB"))
        assertEquals(2, duplicateCountGroupBy("abcdeaB"))
    }

    private fun duplicateCount(str: String): Int {
        val text = str.lowercase()
        return text.associate { c: Char -> c to text.count { it == c } }
            .filterValues { it > 1 }
            .size
    }

    private fun duplicateCountGroupBy(text: String) = text.groupBy(Char::lowercaseChar).count { it.value.count() > 1 }
}
