package codewars.may

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.divideNumbersByGcd
import util.lcm

class SumFractionsTest {

  private fun testing(actual: String, expected: String) {
    assertEquals(expected, actual)
  }

  @Test
  fun basicTests() {
    var a = arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(1, 4))
    var r = "[13, 12]"
    testing(sumFractions(a), r)

    a = arrayOf()
    r = ""
    testing(sumFractions(a), r)
  }

  @Test
  fun hard() {
    val a = arrayOf(intArrayOf(1, 2), intArrayOf(2, 9), intArrayOf(3, 18), intArrayOf(4, 24), intArrayOf(6, 48))
    val r = "[85, 72]"

    testing(sumFractions(a), r)
  }

  @Test
  fun random() {
    val a = arrayOf(intArrayOf(13, 14), intArrayOf(13, 15), intArrayOf(26, 32), intArrayOf(14, 32), intArrayOf(14, 19))
    val r = "[30181, 7980]"

    testing(sumFractions(a), r)
  }

  private fun sumFractions(arr: Array<IntArray>): String {
    if (arr.isEmpty()) return ""

    var sum = arr[0]
    for (i in 1 until arr.size) {
      val current = divideNumbersByGcd(arr[i])
      val lcm = lcm(sum[1], current[1])

      val multi1 = lcm / sum[1]
      val multi2 = lcm / current[1]

      val firstNumerator = sum[0] * multi1
      val secondNumerator = current[0] * multi2

      sum[0] = firstNumerator + secondNumerator
      sum[1] = lcm

      sum = divideNumbersByGcd(sum)
    }
    var num = 0
    if (sum[0] % sum[1] == 0) num = sum[0] / sum[1]

    return if (num != 0) num.toString() else "[${sum[0]}, ${sum[1]}]"
  }
}