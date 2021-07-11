fun mains() {

    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()

    print(first in second..third)
}

fun main() = print(
        readLine()!!.toInt() in readLine()!!.toInt()..readLine()!!.toInt()
)