
package search

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class InterpolationSearchSapientGeneratedTest {

    @Test
    fun testInterpolationSearchWithElementPresent() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        expectThat(interpolationSearch(arr, 0, arr.lastIndex, 7)).isEqualTo(6)
    }

    @Test
    fun testInterpolationSearchWithElementNotPresent() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        expectThat(interpolationSearch(arr, 0, arr.lastIndex, 11)).isEqualTo(-1)
    }

    @Test
    fun testInterpolationSearchWithElementAtStart() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        expectThat(interpolationSearch(arr, 0, arr.lastIndex, 1)).isEqualTo(0)
    }

    @Test
    fun testInterpolationSearchWithElementAtEnd() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        expectThat(interpolationSearch(arr, 0, arr.lastIndex, 10)).isEqualTo(9)
    }

    @Test
    fun testInterpolationSearchWithSingleElementArray() {
        val arr = intArrayOf(5)
        expectThat(interpolationSearch(arr, 0, arr.lastIndex, 5)).isEqualTo(0)
    }

    @Test
    fun testInterpolationSearchWithEmptyArray() {
        val arr = intArrayOf()
        expectThat(interpolationSearch(arr, 0, arr.lastIndex, 5)).isEqualTo(-1)
    }

    @ParameterizedTest
    @MethodSource("provideBoundaryTestCases")
    fun testInterpolationSearchWithBoundaryValues(arr: IntArray, lo: Int, hi: Int, x: Int, expected: Int) {
        expectThat(interpolationSearch(arr, lo, hi, x)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun provideBoundaryTestCases() = listOf(
            Arguments.of(intArrayOf(1, 2, 3, 4, 5), 0, 4, 0, -1),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5), 0, 4, 6, -1),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5), 2, 4, 1, -1),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5), 0, 2, 5, -1)
        )
    }

    @Test
    fun testInterpolationSearchWithRepeatedElements() {
        val arr = intArrayOf(1, 2, 2, 3, 3, 3, 4, 4, 5, 5)
        expectThat(interpolationSearch(arr, 0, arr.lastIndex, 3)).isEqualTo(3)
    }

    @Test
    fun testInterpolationSearchWithNegativeNumbers() {
        val arr = intArrayOf(-10, -5, 0, 5, 10)
        expectThat(interpolationSearch(arr, 0, arr.lastIndex, -5)).isEqualTo(1)
    }

    @Test
    fun testInterpolationSearchWithLargeArray() {
        val arr = IntArray(1000) { it + 1 }
        expectThat(interpolationSearch(arr, 0, arr.lastIndex, 500)).isEqualTo(499)
    }

    @Test
    fun testInterpolationSearchWithInvalidRange() {
        val arr = intArrayOf(1, 2, 3, 4, 5)
        expectThat(interpolationSearch(arr, 3, 1, 2)).isEqualTo(-1)
    }
}
