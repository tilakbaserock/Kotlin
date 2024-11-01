
package dynamicProgramming

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ZeroOneKnapsackProblemSapientGeneratedTest {

    @Test
    fun testZeroOneKnapsackWithValidInput() {
        val W = 50
        val weight = intArrayOf(10, 20, 30)
        val values = intArrayOf(60, 100, 120)
        val n = 3
        assertEquals(220, zerooneknapsack(W, weight, values, n))
    }

    @Test
    fun testZeroOneKnapsackWithZeroCapacity() {
        val W = 0
        val weight = intArrayOf(10, 20, 30)
        val values = intArrayOf(60, 100, 120)
        val n = 3
        assertEquals(0, zerooneknapsack(W, weight, values, n))
    }

    @Test
    fun testZeroOneKnapsackWithEmptyArrays() {
        val W = 50
        val weight = intArrayOf()
        val values = intArrayOf()
        val n = 0
        assertEquals(0, zerooneknapsack(W, weight, values, n))
    }

    @Test
    fun testZeroOneKnapsackWithNegativeCapacity() {
        val W = -10
        val weight = intArrayOf(10, 20, 30)
        val values = intArrayOf(60, 100, 120)
        val n = 3
        assertEquals(0, zerooneknapsack(W, weight, values, n))
    }

    @ParameterizedTest
    @MethodSource("provideKnapsackTestCases")
    fun testZeroOneKnapsackWithVariousInputs(W: Int, weight: IntArray, values: IntArray, n: Int, expected: Int) {
        assertEquals(expected, zerooneknapsack(W, weight, values, n))
    }

    companion object {
        @JvmStatic
        fun provideKnapsackTestCases(): Stream<Arguments> = Stream.of(
            Arguments.of(10, intArrayOf(5, 4, 6, 3), intArrayOf(10, 40, 30, 50), 4, 90),
            Arguments.of(5, intArrayOf(2, 3, 4), intArrayOf(3, 4, 5), 3, 7),
            Arguments.of(8, intArrayOf(3, 2, 4, 1), intArrayOf(4, 3, 5, 6), 4, 13),
            Arguments.of(100, intArrayOf(20, 30, 40, 50), intArrayOf(40, 50, 60, 70), 4, 160)
        )
    }

    @Test
    fun testZeroOneKnapsackWithLargeInput() {
        val W = 1000
        val weight = IntArray(100) { it + 1 }
        val values = IntArray(100) { (it + 1) * 10 }
        val n = 100
        assertTrue(zerooneknapsack(W, weight, values, n) > 0)
    }

    @Test
    fun testZeroOneKnapsackWithSingleItem() {
        val W = 10
        val weight = intArrayOf(5)
        val values = intArrayOf(100)
        val n = 1
        assertEquals(100, zerooneknapsack(W, weight, values, n))
    }

    @Test
    fun testZeroOneKnapsackWithAllItemsExceedingCapacity() {
        val W = 5
        val weight = intArrayOf(10, 20, 30)
        val values = intArrayOf(60, 100, 120)
        val n = 3
        assertEquals(0, zerooneknapsack(W, weight, values, n))
    }
}
