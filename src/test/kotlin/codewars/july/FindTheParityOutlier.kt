package codewars.july

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe


/**
 * You are given an array (which will have a length of at least 3, but could be very large) containing integers.
 * The array is either entirely composed of odd integers or entirely composed of even integers
 * except for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.
 */
class FindTheParityOutlier : DescribeSpec({

    describe("Find single odd or even value in an array") {

        it("should return 3 from [2, 6, 8, -10, 3]") {
            find(arrayOf(2, 6, 8, -10, 3)) shouldBe 2
        }

        it("should return 206847684 from [206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781]") {
            find(arrayOf(206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781)) shouldBe 206847684
        }

        it("should return 0") {
            find(arrayOf(Integer.MAX_VALUE, 0, 1)) shouldBe 0
        }
    }

    describe("Best solution from codewars") {

        it("should return 206847684 from [206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781]") {
            findBestSolution(arrayOf(206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781)) shouldBe 206847684

            val sad = intArrayOf(12321_123123.toInt())
        }
    }
})


fun find(arr: Array<Int>): Int {
    return arr.partition { it % 2 == 0 }.let { if (it.first.size == 1) it.first[0] else it.second[0] }
}

fun findBestSolution(arr: Array<Int>) = arr.singleOrNull { it % 2 == 0 } ?: arr.single { it % 2 == 1 }
