
package dynamicProgramming

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class LCSSapientGeneratedTest {

    @Test
    fun testLcsWithEmptyStrings() {
        expectThat(lcs("", "")).isEqualTo(0)
    }

    @Test
    fun testLcsWithOneEmptyString() {
        expectThat(lcs("abc", "")).isEqualTo(0)
        expectThat(lcs("", "xyz")).isEqualTo(0)
    }

    @Test
    fun testLcsWithIdenticalStrings() {
        expectThat(lcs("abcde", "abcde")).isEqualTo(5)
    }

    @ParameterizedTest
    @CsvSource(
        "stage,sale,3",
        "ABCDGH,AEDFHR,3",
        "AGGTAB,GXTXAYB,4",
        "XMJYAUZ,MZJAWXU,4"
    )
    fun testLcsWithVariousInputs(s1: String, s2: String, expected: Int) {
        expectThat(lcs(s1, s2)).isEqualTo(expected)
    }

    @Test
    fun testLcsWithNoCommonCharacters() {
        expectThat(lcs("ABC", "DEF")).isEqualTo(0)
    }

    @Test
    fun testLcsWithAllCommonCharacters() {
        expectThat(lcs("ABCDEF", "ABCDEF")).isEqualTo(6)
    }

    @Test
    fun testLcsWithRepeatedCharacters() {
        expectThat(lcs("AAAA", "AA")).isEqualTo(2)
    }

    @Test
    fun testLcsWithLongStrings() {
        val s1 = "A".repeat(1000)
        val s2 = "A".repeat(1000)
        expectThat(lcs(s1, s2)).isEqualTo(1000)
    }

    @Test
    fun testLcsWithSpecialCharacters() {
        expectThat(lcs("A!@#$%", "B!@#$%")).isEqualTo(5)
    }

    @Test
    fun testLcsWithUnicode() {
        expectThat(lcs("你好世界", "你好地球")).isEqualTo(2)
    }
}
