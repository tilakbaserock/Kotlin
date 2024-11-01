
package sort

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MergeSortSapientGeneratedTest {

    @Test
    fun testMergeSortWithIntegers() {
        val array = arrayOf(5, 2, 8, 12, 1, 6)
        mergeSort(array, 0, array.size - 1)
        assertArrayEquals(arrayOf(1, 2, 5, 6, 8, 12), array)
    }

    @Test
    fun testMergeSortWithStrings() {
        val array = arrayOf("banana", "apple", "cherry", "date")
        mergeSort(array, 0, array.size - 1)
        assertArrayEquals(arrayOf("apple", "banana", "cherry", "date"), array)
    }

    @Test
    fun testMergeSortWithEmptyArray() {
        val array = emptyArray<Int>()
        mergeSort(array, 0, array.size - 1)
        assertTrue(array.isEmpty())
    }

    @Test
    fun testMergeSortWithSingleElement() {
        val array = arrayOf(42)
        mergeSort(array, 0, array.size - 1)
        assertArrayEquals(arrayOf(42), array)
    }

    @Test
    fun testMergeSortWithReverseSortedArray() {
        val array = arrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
        mergeSort(array, 0, array.size - 1)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), array)
    }

    @Test
    fun testMergeSortWithDuplicates() {
        val array = arrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5)
        mergeSort(array, 0, array.size - 1)
        assertArrayEquals(arrayOf(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9), array)
    }

    @ParameterizedTest
    @MethodSource("provideDifferentTypesArrays")
    fun <T : Comparable<T>> testMergeSortWithDifferentTypes(array: Array<T>, expected: Array<T>) {
        mergeSort(array, 0, array.size - 1)
        assertArrayEquals(expected, array)
    }

    companion object {
        @JvmStatic
        fun provideDifferentTypesArrays(): Stream<Array<Any>> {
            return Stream.of(
                arrayOf(arrayOf(5.5, 1.1, 3.3, 2.2, 4.4), arrayOf(1.1, 2.2, 3.3, 4.4, 5.5)),
                arrayOf(arrayOf('d', 'b', 'a', 'c'), arrayOf('a', 'b', 'c', 'd')),
                arrayOf(arrayOf(true, false, true, false), arrayOf(false, false, true, true))
            )
        }
    }

    @Test
    fun testMergeFunction() {
        val array = arrayOf(2, 4, 6, 1, 3, 5)
        val temp = array.clone()
        merge(array, temp, 0, 2, 5)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 6), array)
    }

    @Test
    fun testMergeFunctionWithEqualElements() {
        val array = arrayOf(1, 3, 5, 1, 3, 5)
        val temp = array.clone()
        merge(array, temp, 0, 2, 5)
        assertArrayEquals(arrayOf(1, 1, 3, 3, 5, 5), array)
    }

    @Test
    fun testMergeFunctionWithSingleElementArrays() {
        val array = arrayOf(2, 1)
        val temp = array.clone()
        merge(array, temp, 0, 0, 1)
        assertArrayEquals(arrayOf(1, 2), array)
    }

    @Test
    fun testMergeSortWithNullableType() {
        val array = arrayOf<Int?>(3, null, 1, 4, null, 2)
        mergeSort(array as Array<Int>, 0, array.size - 1)
        assertArrayEquals(arrayOf<Int?>(null, null, 1, 2, 3, 4), array)
    }
}
