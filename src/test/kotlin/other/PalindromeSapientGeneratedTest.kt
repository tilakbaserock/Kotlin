
package other

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.reflect.Method

class PalindromeSapientGeneratedTest {

    @Test
    fun `isPalindrome returns true for simple palindrome`() {
        assertTrue(isPalindrome("racecar"))
    }

    @Test
    fun `isPalindrome returns false for non-palindrome`() {
        assertFalse(isPalindrome("hello"))
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "a", "aa", "aba", "A man a plan a canal Panama"])
    fun `isPalindrome returns true for various palindromes`(input: String) {
        assertTrue(isPalindrome(input))
    }

    @ParameterizedTest
    @ValueSource(strings = ["ab", "abc", "hello world"])
    fun `isPalindrome returns false for various non-palindromes`(input: String) {
        assertFalse(isPalindrome(input))
    }

    @Test
    fun `isPalindrome handles special characters and spaces`() {
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"))
    }

    @Test
    fun `isPalindrome handles diacritical marks`() {
        assertTrue(isPalindrome("Able was I ere I saw Élba"))
    }

    @Test
    fun `isPalindrome is case-insensitive`() {
        assertTrue(isPalindrome("RaceCar"))
    }

    @Test
    fun `normalize removes spaces`() {
        assertEquals("helloworld", "hello world".normalize())
    }

    @Test
    fun `normalize converts to lowercase`() {
        assertEquals("hello", "HELLO".normalize())
    }

    @Test
    fun `normalize removes diacritical marks`() {
        assertEquals("aceeeiiinoouuy", "áàâäçéèêëíìîïñóòôöúùûü".normalize())
    }

    @Test
    fun `normalize handles empty string`() {
        assertEquals("", "".normalize())
    }

    @Test
    fun `normalize handles string with only spaces`() {
        assertEquals("", "   ".normalize())
    }

    @Test
    fun `isPalindrome handles numeric palindromes`() {
        assertTrue(isPalindrome("11/11/11 11:11"))
        assertTrue(isPalindrome("02/02/2020"))
    }

    @Test
    fun `isPalindrome handles mixed alphanumeric palindromes`() {
        assertTrue(isPalindrome("A1b2c3c2b1a"))
    }

    @Test
    fun `isPalindrome handles very long palindromes`() {
        val longPalindrome = "a".repeat(1000000) + "b" + "a".repeat(1000000)
        assertTrue(isPalindrome(longPalindrome))
    }

    @Test
    fun `isPalindrome handles very long non-palindromes`() {
        val longNonPalindrome = "a".repeat(1000000) + "b" + "a".repeat(999999) + "c"
        assertFalse(isPalindrome(longNonPalindrome))
    }

    @Test
    fun `normalize handles all ASCII printable characters`() {
        val asciiPrintable = (32..126).map { it.toChar() }.joinToString("")
        val normalized = asciiPrintable.normalize()
        assertTrue(normalized.all { it.isLetterOrDigit() })
    }

    @Test
    fun `isPalindrome handles unicode characters`() {
        assertTrue(isPalindrome("νοσον"))
        assertFalse(isPalindrome("νοσος"))
    }
}
