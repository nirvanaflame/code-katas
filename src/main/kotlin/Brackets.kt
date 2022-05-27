import java.util.*

fun main() {
    var index = 0
    val stack: Stack<Char> = Stack()
    "([](){([])})".toCharArray().forEach {
        index++
        when (it) {
            '(', '[', '{' -> {
                stack.push(it)
            }
            ')', ']', '}' -> {
                if (stack.isEmpty()) {
                    print(index)
                    return
                }
                if (!it.matches(stack.pop())) {
                    print(index)
                    return
                }
            } else -> {
              print(index)
              return
        }
        }
    }
    if (stack.isEmpty()) print("Success") else print(index)
}

private fun Char.matches(b: Char?): Boolean {
    return when (this) {
        ')' -> b == '('
        ']' -> b == '['
        '}' -> b == '{'
        else -> false
    }
}
