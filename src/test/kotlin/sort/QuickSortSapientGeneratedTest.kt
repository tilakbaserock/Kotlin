
package sort

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class QuickSortSapientGeneratedTest {

    @Test
    fun testQuickSortWithIntegerArray() {
        val array = arrayOf(5, 2, 9, 1, 7, 6, 3)
        quickSort(array, 0, array.size - 1)
        assertArrayEquals(arrayOf(1, 2, 3, 5, 6, 7, 9), array)
    }

    @Test
    fun testQuickSortWithStringArray() {
        val array = arrayOf("banana", "apple", "cherry", "date")
        quickSort(array, 0, array.size - 1)
        assertArrayEquals(arrayOf("apple", "banana", "cherry", "date"), array)
    }

    @Test
    fun testQuickSortWithEmptyArray() {
        val array = emptyArray<Int>()
        quickSort(array, 0, array.size - 1)
        assertArrayEquals(emptyArray(), array)
    }

    @Test
    fun testQuickSortWithSingleElementArray() {
        val array = arrayOf(1)
        quickSort(array, 0, array.size - 1)
        assertArrayEquals(arrayOf(1), array)
    }

    @Test
    fun testQuickSortWithAlreadySortedArray() {
        val array = arrayOf(1, 2, 3, 4, 5)
        quickSort(array, 0, array.size - 1)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), array)
    }

    @Test
    fun testQuickSortWithReverseSortedArray() {
        val array = arrayOf(5, 4, 3, 2, 1)
        quickSort(array, 0, array.size - 1)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), array)
    }

    @Test
    fun testQuickSortWithDuplicateElements() {
        val array = arrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5)
        quickSort(array, 0, array.size - 1)
        assertArrayEquals(arrayOf(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9), array)
    }

    @ParameterizedTest
    @MethodSource("provideArraysForPartition")
    fun testPartition(array: Array<Int>, low: Int, high: Int, expectedPivotIndex: Int) {
        val pivotIndex = partition(array, low, high)
        assertEquals(expectedPivotIndex, pivotIndex)
        
        for (i in low until pivotIndex) {
            assertTrue(array[i] <= array[pivotIndex])
        }
        for (i in pivotIndex + 1..high) {
            assertTrue(array[i] >= array[pivotIndex])
        }
    }

    companion object {
        @JvmStatic
        fun provideArraysForPartition(): Stream<Arguments> = Stream.of(
            Arguments.of(arrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5), 0, 10, 6),
            Arguments.of(arrayOf(1, 2, 3, 4, 5), 0, 4, 3),
            Arguments.of(arrayOf(5, 4, 3, 2, 1), 0, 4, 3),
            Arguments.of(arrayOf(1), 0, 0, 1),
            Arguments.of(arrayOf(2, 1), 0, 1, 1)
        )
    }

    @Test
    fun testPartitionWithCustomComparable() {
        data class CustomComparable(val value: Int) : Comparable<CustomComparable> {
            override fun compareTo(other: CustomComparable): Int = this.value.compareTo(other.value)
        }

        val array = arrayOf(
            CustomComparable(3),
            CustomComparable(1),
            CustomComparable(4),
            CustomComparable(1),
            CustomComparable(5)
        )

        val pivotIndex = partition(array, 0, array.size - 1)

        for (i in 0 until pivotIndex) {
            assertTrue(array[i].value <= array[pivotIndex].value)
        }
        for (i in pivotIndex + 1 until array.size) {
            assertTrue(array[i].value >= array[pivotIndex].value)
        }
    }

    @Test
    fun testQuickSortWithNullableArray() {
        val array = arrayOf<Int?>(3, null, 1, 4, null, 1, 5, 9, 2, 6, 5)
        quickSort(array as Array<Int>, 0, array.size - 1)
        assertArrayEquals(arrayOf(null, null, 1, 1, 2, 3, 4, 5, 5, 6, 9), array)
    }
}
