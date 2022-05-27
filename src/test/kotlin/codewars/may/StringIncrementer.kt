package codewars.may

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.max

class StringIncrementer {

  @Test
  fun FixedTests() {
    assertEquals(incrementString("foobar000"), "foobar001")
    assertEquals(incrementString("foobar999"), "foobar1000")
    assertEquals(incrementString("foobar00999"), "foobar01000")
    assertEquals(incrementString("foo"), "foo1")
    assertEquals(incrementString("foobar001"), "foobar002")
    assertEquals(incrementString("foobar1"), "foobar2")
    assertEquals(incrementString("1"), "2")
    assertEquals(incrementString(""), "1")
    assertEquals(incrementString("009"), "010")
  }

  private fun incrementString(str: String): String {
    val toInc = str.replace("\\D".toRegex(), "")
    var replace = str.indexOf(toInc)

    val blk: String
    if (toInc.isBlank()) {
      blk = "0"
      replace = str.length
    } else {
      blk = toInc
    }

    val incremented = blk.toInt().inc().toString()

    val toRepeat = max(toInc.length - incremented.length, 0)
    val number = "0".repeat(toRepeat).plus(incremented)
    return str.replaceRange(replace until str.length, number)
  }
}