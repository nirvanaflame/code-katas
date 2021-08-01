package codewars.august

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Born a misinterpretation of this kata, your task here is pretty simple:
 * given an array of values and an amount of beggars,
 * you are supposed to return an array with the sum of what each beggar brings home,
 * assuming they all take regular turns, from the first to the last.
 *
 * For example: [1,2,3,4,5] for 2 beggars will return a result of [9,6],
 * as the first one takes [1,3,5], the second collects [2,4].
 *
 * The same array with 3 beggars would have in turn have produced a better outcome
 * for the second beggar: [5,7,3], as they will respectively take [1,4], [2,5] and [3].
 *
 * Also note that not all beggars have to take the same amount of "offers",
 * meaning that the length of the array is not necessarily a multiple of n;
 * length can be even shorter, in which case the last beggars will of course take nothing (0).
 */
class EnglishBeggarsTest {

    @Test
    fun `zero beggars`() {
        assertEquals(listOf<Int>(), beggars(listOf(1, 2, 3, 4, 5), 0))
    }

    @Test
    fun `only one beggar`() {
        assertEquals(listOf(15), beggars(listOf(1, 2, 3, 4, 5), 1))
    }

    @Test
    fun `two beggars`() {
        assertEquals(listOf(9, 6), beggars(listOf(1, 2, 3, 4, 5), 2))
    }

    @Test
    fun `tree beggars`() {
        assertEquals(listOf(5, 7, 3), beggars(listOf(1, 2, 3, 4, 5), 3))
    }

    @Test
    fun `six beggars`() {
        assertEquals(listOf(1, 2, 3, 4, 5, 0), beggars(listOf(1, 2, 3, 4, 5), 6))
    }

    @Test
    fun `zero beggars with hashMap`() {
        assertEquals(listOf<Int>(), hashMapSolution(listOf(1, 2, 3, 4, 5), 0))
    }

    @Test
    fun `six beggars with hashMap`() {
        assertEquals(listOf(1, 2, 3, 4, 5, 0), hashMapSolution(listOf(1, 2, 3, 4, 5), 6))
    }

    @Test
    fun `six beggars with oneLiner`() {
        assertEquals(listOf(1, 2, 3, 4, 5, 0), oneLiner(listOf(1, 2, 3, 4, 5), 6))
    }

    private fun beggars(values: List<Int>, n: Int): List<Int> {
        val result = List(n) { 0 }.toMutableList()

        for (beg in 1..n) {
            val begg = beg - 1

            values.forEachIndexed { index, v ->
                if ((index == begg) || (index % n == begg)) {
                    result[begg] = result[begg] + v
                }
            }
        }

        return result
    }

    private fun hashMapSolution(values: List<Int>, n: Int): List<Int> {
        val result = hashMapOf<Int, Int>()

        for (i in 0 until n) result[i] = 0

        values.forEachIndexed { index, v ->
            if (index < n) {
                result.merge(index, v, Int::plus)
            } else {
                val i = index % n
                result.merge(i, v, Int::plus)
            }
        }

        return result.values.toList()
    }

    private fun oneLiner(values: List<Int>, n: Int): List<Int> =
        List(n) {
            values.filterIndexed { i, v -> i % n == it }
                .sum()
        }
}