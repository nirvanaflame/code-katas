package util

fun main() {
  val example = "Example"
  example.substring(3)     // 1
  example.substring(0, 7)  // 2
//  example.substring(-1, 0) // 3
  example.substring(0, 0)  // 4
//  example.substring(0, 8)  // 5
}
