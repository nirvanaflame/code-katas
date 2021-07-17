fun main() {
    val s = readLine()!!.first()
    print(s.isDigit().and(s != '0').or(s.isUpperCase()))
}