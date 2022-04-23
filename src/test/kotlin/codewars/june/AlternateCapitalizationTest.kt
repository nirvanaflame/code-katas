@file:Suppress("SpellCheckingInspection")

package codewars.june

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@Suppress("SpellCheckingInspection", "SpellCheckingInspection")
class AlternateCapitalizationTest {

    @Test
    fun `alternate capitalization should return even letter in uppercase`() {
        assertEquals(listOf("AbCdEf", "aBcDeF"), capitalize("abcdef"))
        assertEquals(listOf("CoDeWaRs", "cOdEwArS"), capitalize("codewars"))
        assertEquals(listOf("AbRaCaDaBrA", "aBrAcAdAbRa"), capitalize("abracadabra"))
        assertEquals(listOf("CoDeWaRrIoRs", "cOdEwArRiOrS"), capitalize("codewarriors"))
    }

    private fun capitalize(str: String): List<String> {
        return listOf(
                str.mapIndexed { i, c -> if (i % 2 == 0) c.uppercase() else c.lowercase() }.joinToString(""),
                str.mapIndexed { i, c -> if (i % 2 == 0) c.lowercase() else c.uppercase() }.joinToString("")
        )
    }
}