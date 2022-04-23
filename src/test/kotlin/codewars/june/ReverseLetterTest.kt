package codewars.june

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseLetterTest {


    @Test
    fun `Reverse Letter`() {
        assertEquals("nahsirk", reverseLetter("krishan"))
        assertEquals("nortlu", reverseLetter("ultr53o?n"))
        assertEquals("cba", reverseLetter("ab23c"))
        assertEquals("nahsirk", reverseLetter("krish21an"))
    }

    @Test
    fun `Test Clever Solution Reverse Letter`() {
        assertEquals("nahsirk", cleverSolution("krishan"))
        assertEquals("nortlu", cleverSolution("ultr53o?n"))
        assertEquals("cba", cleverSolution("ab23c"))
        assertEquals("nahsirk", cleverSolution("krish21an"))
    }

    private fun reverseLetter(s: String) =
            s.replace(regex = "[^a-zA-Z]".toRegex(), replacement = "").reversed()

    private fun cleverSolution(s: String) = s.filter(Char::isLetter).reversed()
}