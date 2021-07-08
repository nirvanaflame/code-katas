package codewars.june

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FixStringCaseTest {

    @Test
    fun `should return upper or lowercase`() {
        assertEquals("code", normalize("code"))
        assertEquals("code", normalize("cODe"))
        assertEquals("CODE", normalize("COdE"))
    }

    private fun normalize(s: String): String {
        val up = s.count(Char::isUpperCase)
        return if (up > s.length / 2) s.uppercase() else s.lowercase()
    }
}