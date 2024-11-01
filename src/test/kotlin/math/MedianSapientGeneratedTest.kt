
package math

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MedianSapientGeneratedTest {

    @Test
    fun testMedianWithOddNumberOfElements() {
        val values = intArrayOf(3, 1, 4, 1, 5)
        assertEquals(3.0, median(values))
    }

    @Test
    fun testMedianWithEvenNumberOfElements() {
        val values = intArrayOf(1, 2, 3, 4)
        assertEquals(2.5, median(values))
    }

    @Test
    fun testMedianWithSingleElement() {
        val values = intArrayOf(42)
        assertEquals(42.0, median(values))
    }

    @Test
    fun testMedianWithTwoElements() {
        val values = intArrayOf(1, 2)
        assertEquals(1.5, median(values))
    }

    @Test
    fun testMedianWithNegativeNumbers() {
        val values = intArrayOf(-5, -2, 0, 1, 4)
        assertEquals(0.0, median(values))
    }

    @Test
    fun testMedianWithDuplicateValues() {
        val values = intArrayOf(1, 1, 2, 2, 3)
        assertEquals(2.0, median(values))
    }

    @Test
    fun testMedianWithLargeArray() {
        val values = IntArray(1000) { it }
        assertEquals(499.5, median(values))
    }

    @ParameterizedTest
    @MethodSource("provideArraysForMedian")
    fun testMedianWithParameterizedTests(input: IntArray, expected: Double) {
        assertEquals(expected, median(input))
    }

    companion object {
        @JvmStatic
        fun provideArraysForMedian(): Stream<Arguments> = Stream.of(
            Arguments.of(intArrayOf(1, 2, 3), 2.0),
            Arguments.of(intArrayOf(1, 2, 3, 4), 2.5),
            Arguments.of(intArrayOf(5), 5.0),
            Arguments.of(intArrayOf(-3, -1, 0, 2, 4), 0.0),
            Arguments.of(intArrayOf(1, 1, 1, 1), 1.0)
        )
    }
}
