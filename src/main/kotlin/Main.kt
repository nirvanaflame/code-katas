fun main() {

  val n = readln().toInt()
  val nums = List(n) { readln().toInt() }

  println(nums.stream().min { o1, o2 -> o1 - o2 }.get())
}


