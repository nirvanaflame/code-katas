package util

fun main() {
    val todos: ArrayList<String> = arrayListOf("")

    println("1  Supermarket")
    todos.forEach {
      println("\t" + it)
    }
}
