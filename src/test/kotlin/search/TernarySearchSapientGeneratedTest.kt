
package search

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.math.abs

class TernarySearchSapientGeneratedTest {

    private val epsilon = 1e-3

    @Test
    fun testTernarySearchFindsMinimum() {
        val result = ternarySearch(0.0, 10.0, { x -> x * x - 4 * x + 4 })
        assertEquals(2.0, result, epsilon)
    }

    @Test
    fun testTernarySearchFindsMaximum() {
        val result = ternarySearch(0.0, 10.0, { x -> -(x * x - 4 * x + 4) })
        assertEquals(2.0, result, epsilon)
    }

    @ParameterizedTest
    @CsvSource(
        "0.0, 5.0, 1.0",
        "-10.0, 10.0, 0.0",
        "0.0, 3.14159, 1.5708"
    )
    fun testTernarySearchWithDifferentRanges(left: Double, right: Double, expected: Double) {
        val result = ternarySearch(left, right, { x -> -(x * x) })
        assertEquals(expected, result, epsilon)
    }

    @Test
    fun testTernarySearchWithCustomEpsilon() {
        val customEpsilon = 1e-6
        val result = ternarySearch(0.0, 10.0, { x -> x * x - 4 * x + 4 }, customEpsilon)
        assertEquals(2.0, result, customEpsilon)
    }

    @Test
    fun testTernarySearchWithFlatFunction() {
        val result = ternarySearch(0.0, 10.0, { 5.0 })
        assertTrue(result in 0.0..10.0)
    }

    @Test
    fun testTernarySearchWithStepFunction() {
        val stepFunction: (Double) -> Double = { x ->
            when {
                x < 3.0 -> 1.0
                x < 7.0 -> 0.0
                else -> 2.0
            }
        }
        val result = ternarySearch(0.0, 10.0, stepFunction)
        assertTrue(abs(result - 5.0) <= epsilon)
    }

    @Test
    fun testTernarySearchWithNarrowRange() {
        val result = ternarySearch(1.999, 2.001, { x -> x * x - 4 * x + 4 })
        assertEquals(2.0, result, epsilon)
    }

    @Test
    fun testTernarySearchWithLargeRange() {
        val result = ternarySearch(-1e6, 1e6, { x -> x * x + 1 })
        assertEquals(0.0, result, epsilon)
    }

    @Test
    fun testTernarySearchWithTrigonometricFunction() {
        val result = ternarySearch(0.0, 3.14159, { x -> kotlin.math.sin(x) })
        assertEquals(1.5708, result, epsilon)
    }

    @Test
    fun testTernarySearchWithExponentialFunction() {
        val result = ternarySearch(0.0, 10.0, { x -> kotlin.math.exp(-x) + x })
        assertEquals(1.0, result, epsilon)
    }
}
