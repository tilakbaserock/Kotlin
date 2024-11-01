
package math

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class AverageSapientGeneratedTest {

    @Test
    fun testAverageWithDoubles() {
        val numbers = arrayOf(1.0, 2.0, 3.0, 4.0, 5.0)
        assertEquals(3.0, average(numbers), 0.001)
    }

    @Test
    fun testAverageWithInts() {
        val numbers = arrayOf(1, 2, 3, 4, 5)
        assertEquals(3, average(numbers))
    }

    @Test
    fun testAverageWithSingleDouble() {
        val numbers = arrayOf(42.0)
        assertEquals(42.0, average(numbers), 0.001)
    }

    @Test
    fun testAverageWithSingleInt() {
        val numbers = arrayOf(42)
        assertEquals(42, average(numbers))
    }

    @Test
    fun testAverageWithEmptyDoubleArray() {
        val numbers = emptyArray<Double>()
        assertThrows(ArithmeticException::class.java) {
            average(numbers)
        }
    }

    @Test
    fun testAverageWithEmptyIntArray() {
        val numbers = emptyArray<Int>()
        assertThrows(ArithmeticException::class.java) {
            average(numbers)
        }
    }

    @ParameterizedTest
    @MethodSource("provideDoubleArrays")
    fun testAverageWithVariousDoubleArrays(numbers: Array<Double>, expected: Double) {
        assertEquals(expected, average(numbers), 0.001)
    }

    @ParameterizedTest
    @MethodSource("provideIntArrays")
    fun testAverageWithVariousIntArrays(numbers: Array<Int>, expected: Int) {
        assertEquals(expected, average(numbers))
    }

    companion object {
        @JvmStatic
        fun provideDoubleArrays(): Stream<Arguments> = Stream.of(
            Arguments.of(arrayOf(1.0, 2.0, 3.0), 2.0),
            Arguments.of(arrayOf(0.0, 0.0, 0.0), 0.0),
            Arguments.of(arrayOf(-1.0, 0.0, 1.0), 0.0),
            Arguments.of(arrayOf(Double.MAX_VALUE, Double.MAX_VALUE), Double.MAX_VALUE)
        )

        @JvmStatic
        fun provideIntArrays(): Stream<Arguments> = Stream.of(
            Arguments.of(arrayOf(1, 2, 3), 2),
            Arguments.of(arrayOf(0, 0, 0), 0),
            Arguments.of(arrayOf(-1, 0, 1), 0),
            Arguments.of(arrayOf(Int.MAX_VALUE, Int.MAX_VALUE), Int.MAX_VALUE)
        )
    }
}
