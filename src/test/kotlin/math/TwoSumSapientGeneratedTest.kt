
package math

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

class TwoSumSapientGeneratedTest {

    @Test
    fun testTwoSumWithValidInput() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val expected = intArrayOf(0, 1)
        assertContentEquals(expected, twoSum(nums, target))
    }

    @Test
    fun testTwoSumWithTargetAtEnd() {
        val nums = intArrayOf(3, 2, 4)
        val target = 6
        val expected = intArrayOf(1, 2)
        assertContentEquals(expected, twoSum(nums, target))
    }

    @Test
    fun testTwoSumWithDuplicates() {
        val nums = intArrayOf(3, 3)
        val target = 6
        val expected = intArrayOf(0, 1)
        assertContentEquals(expected, twoSum(nums, target))
    }

    @Test
    fun testTwoSumWithNoSolution() {
        val nums = intArrayOf(1, 2, 3, 4)
        val target = 10
        val expected = intArrayOf(0, 1)
        assertContentEquals(expected, twoSum(nums, target))
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    fun testTwoSumParameterized(nums: IntArray, target: Int, expected: IntArray) {
        assertContentEquals(expected, twoSum(nums, target))
    }

    companion object {
        @JvmStatic
        fun provideTestCases() = listOf(
            Arguments.of(intArrayOf(2, 7, 11, 15), 9, intArrayOf(0, 1)),
            Arguments.of(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2)),
            Arguments.of(intArrayOf(3, 3), 6, intArrayOf(0, 1)),
            Arguments.of(intArrayOf(1, 2, 3, 4), 7, intArrayOf(2, 3)),
            Arguments.of(intArrayOf(1, 2, 3, 4), 10, intArrayOf(0, 1))
        )
    }

    @Test
    fun testTwoSumWithLargeArray() {
        val nums = IntArray(10000) { it }
        val target = 19998
        val expected = intArrayOf(9999, 9999)
        assertContentEquals(expected, twoSum(nums, target))
    }

    @Test
    fun testTwoSumWithNegativeNumbers() {
        val nums = intArrayOf(-1, -2, -3, -4, -5)
        val target = -8
        val expected = intArrayOf(3, 4)
        assertContentEquals(expected, twoSum(nums, target))
    }

    @Test
    fun testTwoSumWithZeroTarget() {
        val nums = intArrayOf(-1, 0, 1)
        val target = 0
        val expected = intArrayOf(0, 2)
        assertContentEquals(expected, twoSum(nums, target))
    }
}
