package codewars.may

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AllInclusiveTest {

  private fun testing(actual:Boolean, expected:Boolean) {
    assertEquals(expected, actual)
  }

  @Test
  fun test() {
    println("Fixed Tests containAllRots")
    var a = arrayListOf("bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs")
    testing(containAllRots("bsjq", a), true)
    a = arrayListOf("TzYxlgfnhf", "yqVAuoLjMLy", "BhRXjYA", "YABhRXj", "hRXjYAB", "jYABhRX", "XjYABhR", "ABhRXjY")
    testing(containAllRots("XjYABhR", a), false)

  }

  private fun containAllRots(st: String, arr: ArrayList<String>): Boolean {

    var l = st.length
    val pattern = st.split("").joinToString("|", "[", "]+").toRegex()
    for (item in arr) {
      if (item.length == st.length && item.replace(regex = pattern, replacement = "").isEmpty()) l--
    }

    return l == 0
  }
}