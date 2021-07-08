package codewars.june

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.abs

class MaximumLengthDifferenceTest {

    @Test
    fun `should return max length difference`() {
        var s1 = arrayOf("hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz")
        var s2 = arrayOf("cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww")

        assertEquals(13, mxdiflg(s1, s2))

        s1 = arrayOf("ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh")
        s2 = arrayOf("bbbaaayddqbbrrrv")
        assertEquals(10, mxdiflg(s1, s2))
    }

    @Test
    fun `check best solution`() {
        var s1 = arrayOf("hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz")
        var s2 = arrayOf("cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww")

        assertEquals(13, bestSolution(s1, s2))

        s1 = arrayOf("ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh")
        s2 = arrayOf("bbbaaayddqbbrrrv")
        assertEquals(10, bestSolution(s1, s2))
    }

    fun mxdiflg(a1: Array<String>, a2: Array<String>): Int {
        if (a1.isEmpty() || a2.isEmpty()) return -1

        val a1Max: Int = a1.maxByOrNull { it.length }?.length!!
        val a1Min: Int = a1.minByOrNull { it.length }?.length!!

        val a2Max: Int = a2.maxByOrNull { it.length }?.length!!
        val a2Min: Int = a2.minByOrNull { it.length }?.length!!


        return Math.max(abs(a1Min - a2Max), abs(a1Max - a2Min))
    }


    fun bestSolution(a1: Array<String>, a2: Array<String>) =
            a1.flatMap { s1 -> a2.map { s2 -> abs(s1.length - s2.length) } }
                    .maxOrNull()
}