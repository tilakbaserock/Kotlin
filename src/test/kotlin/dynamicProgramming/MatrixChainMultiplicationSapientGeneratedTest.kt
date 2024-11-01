
package dynamicProgramming

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MatrixChainMultiplicationSapientGeneratedTest {

    @Test
    fun `test matrix chain order with small input`() {
        val p = intArrayOf(10, 20, 30, 40, 30)
        assertEquals(30000, MatrixChainOrder(p))
    }

    @Test
    fun `test matrix chain order with single matrix`() {
        val p = intArrayOf(5, 10)
        assertEquals(0, MatrixChainOrder(p))
    }

    @Test
    fun `test matrix chain order with two matrices`() {
        val p = intArrayOf(2, 3, 4)
        assertEquals(24, MatrixChainOrder(p))
    }

    @Test
    fun `test matrix chain order with larger input`() {
        val p = intArrayOf(40, 20, 30, 10, 30)
        assertEquals(26000, MatrixChainOrder(p))
    }

    @ParameterizedTest
    @MethodSource("provideMatrixChainInputs")
    fun `test matrix chain order with various inputs`(input: IntArray, expected: Int) {
        assertEquals(expected, MatrixChainOrder(input))
    }

    @Test
    fun `test matrix chain order with maximum possible dimensions`() {
        val p = IntArray(101) { it + 1 }
        assertTrue(MatrixChainOrder(p) > 0)
    }

    companion object {
        @JvmStatic
        fun provideMatrixChainInputs(): Stream<Array<Any>> = Stream.of(
            arrayOf(intArrayOf(30, 35, 15, 5, 10, 20, 25), 15125),
            arrayOf(intArrayOf(5, 10, 3, 12, 5, 50, 6), 2010),
            arrayOf(intArrayOf(10, 20, 30), 6000),
            arrayOf(intArrayOf(40, 20, 30, 10, 30), 26000)
        )
    }
}
