package util

import java.util.*

fun main() {
    val arr = intArrayOf(-1, 0, 3, 5, 9, 12)
    println(search(arr, 9))
}


fun search(nums: IntArray, target: Int): Int {

    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val middle = (left + right) / 2

        if (nums[middle] == target) return middle
        else if (middle > target) right = middle - 1
        else left = middle + 1
    }

    return -1
}

fun sortedSquares(nums: IntArray): IntArray {

  return nums.map { it * it }.sorted().toIntArray()
}