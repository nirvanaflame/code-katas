package codewars.may

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test


@Disabled("Forgotten Kotlin")
class CodeMonk {

    @Test
    fun shouldCountDigits() {
        val input = """
            2
            3
            1 2 3
            4 5 6
            7 8 9
            2
            4 3
            1 4
        """.trimIndent()
        Assertions.assertEquals(arrayOf(0, 2), countInversions(input))
//        Assertions.assertEquals(1, nbDig(3, 4))
    }

    private fun countInversions(input: String): IntArray {
        return intArrayOf(0, 2)
    }
}
