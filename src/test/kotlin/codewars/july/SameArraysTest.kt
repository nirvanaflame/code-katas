package codewars.july

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Given two arrays a and b write a function comp(a, b) (orcompSame(a, b))
 * that checks whether the two arrays have the "same" elements,
 * with the same multiplicities. "Same" means, here, that the elements in b
 * are the elements in a squared, regardless of the order.
 */
class SameArraysTest {

    @Test
    fun `first array powered should be equal to second`() {
        val a1 = intArrayOf(121, 144, 19, 161, 19, 144, 19, 11)
        val a2 = intArrayOf(121, 14641, 20736, 361, 25921, 361, 20736, 361)

        assertEquals(true, compareArrays(a1, a2))
    }

    @Test
    fun `first array is null`() {
        val a1 = null
        val a2 = intArrayOf(11 * 11, 121 * 121, 144 * 144, 19 * 19, 161 * 161, 19 * 19, 144 * 144, 19 * 19)

        assertEquals(false, compareArrays(a1, a2))
    }

    @Test
    fun `second array is null`() {
        val a1 = intArrayOf(121, 144, 19, 161, 19, 144, 19, 11)
        val a2 = null

        assertEquals(false, compareArrays(a1, a2))
    }

    @Test
    fun `two array are null`() {
        val a1 = null
        val a2 = null

        assertEquals(false, compareArrays(a1, a2))
    }

    @Test
    fun `first array is empty`() {
        val a1 = intArrayOf()
        val a2 = intArrayOf(11 * 11, 121 * 121, 144 * 144, 19 * 19, 161 * 161, 19 * 19, 144 * 144, 19 * 19)

        assertEquals(false, compareArrays(a1, a2))
    }

    @Test
    fun `second array is empty`() {
        val a1 = intArrayOf(121, 144, 19, 161, 19, 144, 19, 11)
        val a2 = intArrayOf()

        assertEquals(false, compareArrays(a1, a2))
    }

    @Test
    fun `both array are empty`() {
        val a1 = intArrayOf()
        val a2 = intArrayOf()

        assertEquals(true, compareArrays(a1, a2))
    }

    fun compareArrays(a1: IntArray?, a2: IntArray?): Boolean {
        if (a1 == null || a2 == null) return false

        return a1.map { it * it }.sorted() == a2.sorted()
    }
}