package codewars.may

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class OpstringsTest {
    private fun testing(actual: String, expected: String) {
        assertEquals(expected, actual)
    }

    @Test
    fun test() {
        println("Fixed Tests rot")
        testing(Opstrings.oper(Opstrings::rot, "fijuoo\nCqYVct\nDrPmMJ\nerfpBA\nkWjFUG\nCVUfyL"),
            "LyfUVC\nGUFjWk\nABpfre\nJMmPrD\ntcVYqC\nooujif")
        testing(Opstrings.oper(Opstrings::rot, "rkKv\ncofM\nzXkh\nflCB"),
            "BClf\nhkXz\nMfoc\nvKkr")

        println("Fixed Tests selfieAndRot")
        testing(Opstrings.oper( Opstrings::selfieAndRot, "xZBV\njsbS\nJcpN\nfVnP"),
            "xZBV....\njsbS....\nJcpN....\nfVnP....\n....PnVf\n....NpcJ\n....Sbsj\n....VBZx")
        testing(Opstrings.oper( Opstrings::selfieAndRot, "uLcq\nJkuL\nYirX\nnwMB"),
            "uLcq....\nJkuL....\nYirX....\nnwMB....\n....BMwn\n....XriY\n....LukJ\n....qcLu")

    }
}

object Opstrings {

    fun rot(str: String): String {
        return rot(str, "\n")
    }

    fun rot(str: String, sep:String): String {
        return str.split("\n").map { StringBuilder(it).reverse() }.reversed().joinToString(sep)
    }

    fun selfieAndRot(str: String): String {
        val len = str.split("\n")[0].length
        val sep = ".".repeat(len)
        val s = str.replace("\n", "$sep\n")

        return "$s$sep\n$sep${rot(str, "\n$sep")}"
    }
    fun oper(apply: (input: String) -> String, s: String): String {
        return apply(s)
    }
}