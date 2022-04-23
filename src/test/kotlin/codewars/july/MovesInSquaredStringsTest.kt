@file:Suppress("GrazieInspection")

package codewars.july

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * You are given a string of n lines, each substring being n characters long:
 * For example:
 * s = "abcd\nefgh\nijkl\nmnop"
 *
 * We will study some transformations of this square of strings.
 * Vertical mirror: vert_mirror (or vertMirror or vert-mirror)
 * vert_mirror(s) => "dcba\nhgfe\nlkji\nponm"
 *
 * Horizontal mirror: hor_mirror (or horMirror or hor-mirror)
 * hor_mirror(s) => "mnop\nijkl\nefgh\nabcd"
 *
 * vertical mirror   |horizontal mirror
 * abcd --> dcba     |abcd --> mnop
 * efgh     hgfe     |efgh     ijkl
 * ijkl     lkji     |ijkl     efgh
 * mnop     ponm     |mnop     abcd
 */
class MovesInSquaredStringsTest {

    @Test
    fun `should mirror strings vertically `() {
        val str = "hSgdHQ\nHnDMao\nClNNxX\niRvxxH\nbqTVvA\nwvSyRu"
        val expected = "QHdgSh\noaMDnH\nXxNNlC\nHxxvRi\nAvVTqb\nuRySvw"
        assertEquals(Opstrings.oper(Opstrings::vertMirror, str), expected)
    }

    @Test
    fun `should mirror strings vertically2`() {
        val str = "IzOTWE\nkkbeCM\nWuzZxM\nvDddJw\njiJyHF\nPVHfSx"
        val expected = "EWTOzI\nMCebkk\nMxZzuW\nwJddDv\nFHyJij\nxSfHVP"
        assertEquals(Opstrings.oper(Opstrings::vertMirror, str), expected)
    }

    @Test
    fun `should mirror strings horizontally`() {
        val str = "lVHt\nJVhv\nCSbg\nyeCt"
        val expected = "yeCt\nCSbg\nJVhv\nlVHt"
        assertEquals(Opstrings.oper(Opstrings::horMirror, str), expected)
    }

    @Test
    fun `should mirror strings horizontally2`() {
        val str = "njMK\ndbrZ\nLPKo\ncEYz"
        val expected = "cEYz\nLPKo\ndbrZ\nnjMK"
        assertEquals(Opstrings.oper(Opstrings::horMirror, str), expected)
    }

}

object Opstrings {
    fun oper(f: Function1<String, String>, s: String): String {
        return f.invoke(s)
    }

    fun vertMirror(s: String): String {
        return s.split("\n").joinToString("\n") { it.reversed() }
    }

    fun horMirror(s: String): String {
        return s.split("\n").reversed().joinToString("\n")
    }
}
