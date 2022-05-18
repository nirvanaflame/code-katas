fun main() {
    var sum = 0

    while(true) {
        val x = readln().toInt()
        if (x == 0) break
        sum += x
    }

    println(sum)
}