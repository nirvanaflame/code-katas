import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * You are given an array (which will have a length of at least 3, but could be very large) containing integers.
 * The array is either entirely comprised of odd integers or entirely comprised of even integers
 * except for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.
 */
class FindTheParityOutlier {

    @Test
    fun `should return 3`() {
        assertEquals(3, find(arrayOf(2, 6, 8, -10, 3)))
    }

    @Test
    fun `should return big number`() {
        assertEquals(206847684, find(arrayOf(206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781)))
    }

    @Test
    fun `should return 0`() {
        assertEquals(0, find(arrayOf(Integer.MAX_VALUE, 0, 1)))
    }

    @Test
    fun `singleOrNull returns element which suites predicate or null if many`() {
        assertEquals(206847684, findBestSolution(arrayOf(206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781)))
    }

    fun find(arr: Array<Int>): Int {
        return arr.partition { it % 2 == 0 }.let { if (it.first.size == 1) it.first[0] else it.second[0] }
    }

    fun findBestSolution(arr: Array<Int>) = arr.singleOrNull { it % 2 == 0 } ?: arr.single { it % 2 == 1 }
}