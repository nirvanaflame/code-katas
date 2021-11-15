package codewars.july

import org.junit.jupiter.api.Test
import kotlin.math.pow
import kotlin.test.assertEquals

/*
* Some numbers have funny properties. For example:
*
* 89 --> 8¹ + 9² = 89 * 1
* 695 --> 6² + 9³ + 5⁴= 1390 = 695 * 2
* 46288 --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
* Given a positive integer n written as abcd... (a, b, c, d... being digits) and a positive integer p
* we want to find a positive integer k, if it exists,
* such as the sum of the digits of n taken to the successive powers of p is equal to k * n.
*
* In other words:
* Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) + ...) = n * k
*
* If it is the case we will return k, if not return -1.
*
* Note: n and p will always be given as strictly positive integers.
*
*/
class PlayingWithDigitsTest {

    @Test
    fun `should return 1`() {
        assertEquals(1, digPow(89, 1))
    }

    @Test
    fun `should return -1`() {
        assertEquals(-1, digPow(92, 1))
    }

    @Test
    fun `should return 51`() {
        assertEquals(51, digPow(46288, 3))
    }

    @Test
    fun `should return 51 for one liner`() {
        println(callPowerInfix())
        assertEquals(51, digitPow(46288, 3))
    }

    fun callPowerInfix(): Int {
        return 2 `^^` 2
    }

    fun digPow(denominator: Int, initialPower: Int): Int {
        var power = initialPower

        val numberWithPoweredDigits: Int = denominator.toString()
            .map(Character::getNumericValue)
            .fold(0) { acc, i -> acc + i.pow(power++) }

        return if (numberWithPoweredDigits % denominator == 0) numberWithPoweredDigits / denominator else -1
    }

    fun Int.pow(p: Int) = this.toDouble().pow(p.toDouble()).toInt()

    infix fun Int.`^^`(p: Int) = this.toDouble().pow(p).toInt()

    fun digitPow(n: Int, p: Int) =
        n.toString()
            .map(Character::getNumericValue)
            .foldIndexed(0) { index: Int, acc: Int, each: Int -> acc + (each `^^` (p + index)) }
            .let { if (it % n == 0) it / n else -1 }
}

