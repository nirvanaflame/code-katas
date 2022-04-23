fun main() {
    println(staircase(4))
}

fun staircase(n: Int): Int {
    var a = 1; val b = 2

    var cache = 0
    for (i in 1 until n) {
        a += b
    }

    return a
}
