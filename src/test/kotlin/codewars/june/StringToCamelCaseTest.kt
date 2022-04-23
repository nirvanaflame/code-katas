package codewars.june

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class StringToCamelCaseTest {

    @Test
    fun shouldConvertStringToCamelCase() {
        assertEquals("theStealthWarrior", toCamelCaseFirstTry("the_stealth_warrior"))
    }

    @Test
    fun shouldLowerFirstLetter() {
        assertEquals("theStealthWarrior", toCamelCaseFirstTry("The-Stealth-Warrior"))
    }

    @Test
    fun shouldReturnAllUppercase() {
        assertEquals("ABC", toCamel("A-B-C"))
        assertEquals("ABC", toCamelCaseOldCodeWars("A-B-C"))
    }

    @Test
    fun testEmptyString() {
        assertEquals("", toCamel(""))
    }

    private fun bestToCamel(str: String) =
        str.split("-", "_")
            .mapIndexed { i, s -> if (i != 0) s.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } else s }
            .joinToString("")


    private fun toCamel(str: String): String {
        str.ifBlank { return str }

        var result = ""
        str.split("-", "_")
            .forEachIndexed { i, s ->
                result += if (i == 0 && s[0].isLowerCase()) s else s.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }
            }

        return result
    }


    private fun toCamelCaseFirstTry(str: String): String =
        str.split("-", "_")
            .joinToString(separator = "") { s ->
                when {
                    s.length == 1 -> s.uppercase()
                    s in str.substring(0..s.length) -> s.replaceFirstChar { c -> c.lowercase() }
                    else -> s.replaceFirstChar { c ->
                        if (c.isLowerCase()) c.titlecase(Locale.getDefault()) else c.toString()
                    }
                }
            }

    private fun toCamelCaseOldCodeWars(str: String): String =
        str.split("-", "_")
            .joinToString(separator = "") { s ->
                if (s in str.substring(0..s.length) && s.length > 1) s.lowercase() else s.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }
            }
}


