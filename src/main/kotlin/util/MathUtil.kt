package util

fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
fun lcm(a: Int, b: Int): Int = a / gcd(a, b) * b

fun divideNumbersByGcd(pair: IntArray): IntArray {
  val gcd = gcd(pair[0], pair[1])
  if (gcd != 1) {
    pair[0] /= gcd
    pair[1] /= gcd
  }
  return pair
}