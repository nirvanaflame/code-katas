package dp

fun climbStairs(n: Int): Int {
    if (n <= 2) return n

    val dp = IntArray(n + 1) { 1 }

    for (i in 2..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[n]
}

fun climbStairsBest(n: Int): Int {
    if (n <= 2) return n
    var step1 = 1
    var step2 = 1

    for (i in 2..n){
        val cur = step2
        step2 = step1 + cur
        step1 = cur
    }
    return step2
}

fun main() {
    println(climbStairsBest(5) == climbStairs(5))
}