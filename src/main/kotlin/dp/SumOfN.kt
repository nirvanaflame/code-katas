package dp

fun nSum(n: Int): Int {
    if (n <= 1) return n
    val dp = IntArray(n + 1) { 0 }
    for (i in 1..n) {
        dp[i] = i + dp[i - 1]
    }
    return dp[n]
}

fun mSum(n: Int): Int {
    return n * (n + 1) / 2
}

fun main() {
    println(nSum(12))
    println(mSum(12))
    println(mSum(12) == nSum(12))
}
