package dp

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

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

    for (i in 2..n) {
        val cur = step2
        step2 = step1 + cur
        step1 = cur
    }
    return step2
}

fun climbStairsThreeSteps(n: Int): Int {

    var a = 1
    var b = 1
    var c = 2
    var d = 0

    for (i in 3..n) {
        d = a + b + c
        a = b
        b = c
        c = d
    }

    return d
}

fun climbStairsKSteps(n: Int, k: Int): Int {
    val dp = IntArray(n + 1)
    dp[0] = 1
    dp[1] = 1
    for (i in 2..n) {
        for (j in 1..k) {
            if (i - j < 0) continue
            dp[i] += dp[i - j]
        }
    }
    return dp[n]
}

fun climbStairsKStepsMemOptimized(n: Int, k: Int): Int {
    val dp = IntArray(k)
    dp[0] = 1
    for (i in 1..n) {
        for (j in 1 until k) {
            if (i - j < 0) continue
            dp[i % k] += dp[(i - j) % k]
        }
    }
    return dp[n % k]
}

fun climbStairsKStepsSkippedRed(n: Int, k: Int, stairs: BooleanArray): Int {
    val dp = IntArray(k)
    dp[0] = 1
    for (i in 1..n) {
        for (j in 1 until k) {
            if (i - j < 0) continue
            if (stairs[i - 1]) {
                dp[i % k] = 0
            } else {
                dp[i % k] += dp[(i - j) % k]
            }
        }
    }
    return dp[n % k]
}

fun paidStaircase(n: Int, p: IntArray): Int {
    val dp = IntArray(n + 1)
    dp[0] = 0
    dp[1] = p[1]
    for (i in 2..n) {
        dp[i] = min(dp[i - 1], dp[i - 2]) + p[i]
    }
    return dp[n]
}

fun paidStaircaseCheapPath(n: Int, p: IntArray): Int {
    var dp = IntArray(n + 1)
    var from = ArrayList<Int>()
    dp[0] = 0
    dp[1] = p[1]

    for (i in 2..n) {
        from += if (dp[i - 1] > dp[i - 2]) dp[i - 2] else dp[i - 1]
        dp[i] = min(dp[i - 1], dp[i - 2]) + p[i]
    }
    return from.size
}


fun main() {
    println(paidStaircaseCheapPath(3, intArrayOf(0, 3, 2, 4)))

//    println(paidStaircase(3, intArrayOf(0, 3, 2, 4)))
//
//    println(
//        climbStairsKStepsSkippedRed(
//            7, 3,
//            booleanArrayOf(false, true, false, true, true, false, false)
//        )
//    )
//    println(climbStairsKSteps(5, 3) == climbStairsKStepsMemOptimized(5, 3))
//    println(climbStairsKSteps(5, 3) == climbStairsThreeSteps(5))
//    println(climbStairsKSteps(5, 2) == climbStairs(5))
//
//    println(climbStairsThreeSteps(5) == climbStairs(6))
//    println(climbStairsBest(5) == climbStairs(5))
}