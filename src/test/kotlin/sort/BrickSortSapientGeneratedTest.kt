
package sort

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class BrickSortSapientGeneratedTest {

    @Test
    fun testOddEvenSortWithIntegers() {
        val array = arrayOf(5, 3, 2, 7, 8, 1, 9, 4, 6)
        oddEvenSort(array)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), array)
    }

    @Test
    fun testOddEvenSortWithStrings() {
        val array = arrayOf("banana", "apple", "cherry", "date")
        oddEvenSort(array)
        assertArrayEquals(arrayOf("apple", "banana", "cherry", "date"), array)
    }

    @Test
    fun testOddEvenSortWithEmptyArray() {
        val array = emptyArray<Int>()
        oddEvenSort(array)
        assertTrue(array.isEmpty())
    }

    @Test
    fun testOddEvenSortWithSingleElement() {
        val array = arrayOf(1)
        oddEvenSort(array)
        assertArrayEquals(arrayOf(1), array)
    }

    @Test
    fun testOddEvenSortWithAlreadySortedArray() {
        val array = arrayOf(1, 2, 3, 4, 5)
        oddEvenSort(array)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), array)
    }

    @Test
    fun testOddEvenSortWithReverseSortedArray() {
        val array = arrayOf(5, 4, 3, 2, 1)
        oddEvenSort(array)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), array)
    }

    @Test
    fun testOddEvenSortWithDuplicateElements() {
        val array = arrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5)
        oddEvenSort(array)
        assertArrayEquals(arrayOf(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9), array)
    }

    @ParameterizedTest
    @MethodSource("provideDifferentTypesArrays")
    fun <T : Comparable<T>> testOddEvenSortWithDifferentTypes(input: Array<T>, expected: Array<T>) {
        oddEvenSort(input)
        assertArrayEquals(expected, input)
    }

    companion object {
        @JvmStatic
        fun provideDifferentTypesArrays(): Stream<Array<Array<out Comparable<*>>>> {
            return Stream.of(
                arrayOf(arrayOf(5.5, 3.3, 7.7, 1.1), arrayOf(1.1, 3.3, 5.5, 7.7)),
                arrayOf(arrayOf('d', 'b', 'a', 'c'), arrayOf('a', 'b', 'c', 'd')),
                arrayOf(arrayOf(true, false, true, false), arrayOf(false, false, true, true))
            )
        }
    }

    @Test
    fun testOddEvenSortWithNullableElements() {
        val array = arrayOf<Int?>(3, null, 1, 4, null, 2)
        oddEvenSort(array as Array<Int>)
        assertArrayEquals(arrayOf(null, null, 1, 2, 3, 4), array)
    }

    @Test
    fun testOddEvenSortWithLargeArray() {
        val array = (1..10000).shuffled().toTypedArray()
        val expected = array.sorted().toTypedArray()
        oddEvenSort(array)
        assertArrayEquals(expected, array)
    }
}
