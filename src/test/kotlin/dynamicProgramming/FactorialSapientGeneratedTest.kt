
package dynamicProgramming

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class FactorialSapientGeneratedTest {

    @Test
    fun `test factorial of zero returns one`() {
        expectThat(factorial(0)).isEqualTo(1)
    }

    @Test
    fun `test factorial of one returns one`() {
        expectThat(factorial(1)).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [2, 3, 4, 5])
    fun `test factorial of positive numbers`(n: Int) {
        val expected = (1..n).reduce { acc, i -> acc * i }
        expectThat(factorial(n)).isEqualTo(expected)
    }

    @Test
    fun `test factorial of five`() {
        expectThat(factorial(5)).isEqualTo(120)
    }

    @Test
    fun `test factorial of ten`() {
        expectThat(factorial(10)).isEqualTo(3628800)
    }

    @Test
    fun `test factorial with custom accumulator`() {
        expectThat(factorial(5, 2)).isEqualTo(240)
    }

    @Test
    fun `test factorial of large number does not cause stack overflow`() {
        expectThat(factorial(10000)).isEqualTo(0) // Due to integer overflow
    }

    @Test
    fun `test factorial of negative number`() {
        expectThat(factorial(-1)).isEqualTo(1) // Assuming factorial of negative numbers returns 1
    }
}
