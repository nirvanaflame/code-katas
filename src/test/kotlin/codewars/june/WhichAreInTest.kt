package codewars.june

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class WhichAreInTest {

    @Test
    fun testInArray() {
        val a2 = arrayOf("lively", "alive", "harp", "sharp", "armstrong")
        assertArrayEquals(arrayOf("live", "strong"), inArray(arrayOf("xyz", "live", "strong"), a2))
        assertArrayEquals(arrayOf("arp", "live", "strong"), inArray(arrayOf("live", "strong", "arp"), a2))
        assertArrayEquals(arrayOf<String>(), inArray(arrayOf("tarp", "mice", "bull"), a2))
    }

    private fun inArray(first: Array<String>, second: Array<String>): Array<String> =
            first.distinct()
                .filter { substring -> second.any { it.contains(substring) } }
                .find {  }
                .sorted()
                .toTypedArray()
}
