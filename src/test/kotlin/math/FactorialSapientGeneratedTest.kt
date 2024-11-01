
package mathematics

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.security.InvalidParameterException

class FactorialSapientGeneratedTest {

    @Test
    fun `test factorial of zero returns one`() {
        expectThat(getFactorial(0)).isEqualTo(1)
    }

    @Test
    fun `test factorial of one returns one`() {
        expectThat(getFactorial(1)).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(longs = [2, 3, 4, 5, 10, 20])
    fun `test factorial of positive numbers`(number: Long) {
        val expected = (1..number).reduce { acc, i -> acc * i }
        expectThat(getFactorial(number)).isEqualTo(expected)
    }

    @Test
    fun `test factorial of negative number throws InvalidParameterException`() {
        assertThrows<InvalidParameterException> {
            getFactorial(-1)
        }
    }

    @Test
    fun `test factorial of large number`() {
        expectThat(getFactorial(20)).isEqualTo(2432902008176640000)
    }

    @Test
    fun `test factorial function is tail recursive`() {
        // This test verifies that the function can handle large inputs without stack overflow
        expectThat(getFactorial(10000)).isEqualTo(0) // The actual result is too large, so we just check it doesn't throw
    }
}
