package codewars.june

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * In this kata you have to write a simple Morse code decoder.
 * While the Morse code is now mostly superseded by voice and digital data communication channels,
 * it still has its use in some applications around the world.
 * The Morse code encodes every character as a sequence of "dots" and "dashes".
 * For example, the letter A is coded as ·−, letter Q is coded as −−·−,
 * and digit 1 is coded as ·−−−−. The Morse code is case-insensitive,
 * traditionally capital letters are used. When the message is written in Morse code,
 * a single space is used to separate the character codes and 3 spaces are used to separate words.
 * For example, the message HEY JUDE in Morse code is ···· · −·−−   ·−−− ··− −·· ·.
 */
class DecodeTheMorseCodeTest {

    @Test
    fun `translate HEY JUDE from the Morse Code`() {
        assertEquals("HEY JUDE", decodeMorse(".... . -.--   .--- ..- -.. ."))
        assertEquals("HEY JUDE", decodeMorseWithTransform(".... . -.--   .--- ..- -.. ."))
        assertEquals("HEY JUDE", decodeMorseOldFashion(".... . -.--   .--- ..- -.. ."))
    }

    @Test
    fun `translate ' E ' from the Morse Code`() {
        assertEquals("E", decodeMorse(" . "))
        assertEquals("E", decodeMorseWithTransform(" . "))
        assertEquals("E", decodeMorseOldFashion(" . "))
    }

    private fun decodeMorse(code: String) =
            code.split(" ")
                .joinToString("") { MorseCode[it] ?: " " }
                .replace("(\\s)+".toRegex(), " ")
                .trim()

    private fun decodeMorseWithTransform(code: String) =
            code.split(" ")
                .joinToString("", transform = MorseCode::getOrDefault)
                .replace("(\\s)+".toRegex(), " ")
                .trim()

    private fun decodeMorseOldFashion(code: String): String {
        var morseCode = ""
        code.split(" ").forEach {
            morseCode += MorseCode[it] ?: " "
        }
        return morseCode.replace(regex = "(\\s)+".toRegex(), " ").trim()
    }
}

object MorseCode {

    private val codeMap: Map<String, String> = mapOf(
            ".-" to "A", "-..." to "B", "-.-." to "C", "-.." to "D",
            "." to "E", "..-." to "F", "--." to "G", "...." to "H",
            ".." to "I", ".---" to "J", "-.-" to "K", ".-.." to "L",
            "--" to "M", "-." to "N", "---" to "O", ".--." to "P",
            "--.-" to "Q", ".-." to "R", "..." to "S", "-" to "T",
            "..-" to "U", "...-" to "V", ".--" to "W", "-..-" to "X",
            "-.--" to "Y", "--.." to "Z"
    ) as HashMap<String, String>

    operator fun get(code: String): String? {
        return codeMap[code]
    }

    infix fun getOrDefault(code: String) = this.getOrDefault(code, " ")

    private fun getOrDefault(code: String, default: String) = get(code) ?: default
}
