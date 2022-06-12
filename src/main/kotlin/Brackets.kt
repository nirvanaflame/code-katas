import java.util.*

fun main() {
  val list: LinkedList<Int> = LinkedList(
    readLine()!!.split(" ").map(String::toInt)
  )
  list.removeFirst()

  val rotate = list.removeLast()
  repeat(rotate) {
    list.addFirst(list.removeLast())
  }
}
