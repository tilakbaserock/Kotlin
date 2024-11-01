
package sort

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class InsertionSortSapientGeneratedTest {

    @Test
    fun testInsertionSortWithIntegers() {
        val array = arrayOf(5, 2, 8, 12, 1, 6)
        insertionSort(array)
        assertArrayEquals(arrayOf(1, 2, 5, 6, 8, 12), array)
    }

    @Test
    fun testInsertionSortWithStrings() {
        val array = arrayOf("banana", "apple", "cherry", "date")
        insertionSort(array)
        assertArrayEquals(arrayOf("apple", "banana", "cherry", "date"), array)
    }

    @Test
    fun testInsertionSortWithEmptyArray() {
        val array = emptyArray<Int>()
        insertionSort(array)
        assertTrue(array.isEmpty())
    }

    @Test
    fun testInsertionSortWithSingleElement() {
        val array = arrayOf(42)
        insertionSort(array)
        assertArrayEquals(arrayOf(42), array)
    }

    @Test
    fun testInsertionSortWithAlreadySortedArray() {
        val array = arrayOf(1, 2, 3, 4, 5)
        insertionSort(array)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), array)
    }

    @Test
    fun testInsertionSortWithReverseSortedArray() {
        val array = arrayOf(5, 4, 3, 2, 1)
        insertionSort(array)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), array)
    }

//    @ParameterizedTest
//    @MethodSource("provideArraysForSorting")
//    fun testInsertionSortWithVariousArrays(input: Array<Int>, expected: Array<Int>) {
//        insertionSort(input)
//        assertArrayEquals(expected, input)
//    }

    companion object {
        @JvmStatic
        fun provideArraysForSorting(): Stream<Array<Array<Int>>> {
            return Stream.of(
                arrayOf(arrayOf(3, 1, 4, 1, 5, 9, 2, 6), arrayOf(1, 1, 2, 3, 4, 5, 6, 9)),
                arrayOf(arrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1), arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)),
                arrayOf(arrayOf(1, 1, 1, 1), arrayOf(1, 1, 1, 1)),
                arrayOf(arrayOf(Int.MAX_VALUE, 0, Int.MIN_VALUE), arrayOf(Int.MIN_VALUE, 0, Int.MAX_VALUE))
            )
        }
    }

    @Test
    fun testInsertionSortWithNullableArray() {
        val array: Array<Int?> = arrayOf(3, null, 1, 4, null, 2)
        insertionSort(array.filterNotNull().toTypedArray())
        assertArrayEquals(arrayOf(1, 2, 3, 4), array.filterNotNull().toTypedArray())
    }

    @Test
    fun testInsertionSortWithCustomComparable() {
        data class Person(val name: String, val age: Int) : Comparable<Person> {
            override fun compareTo(other: Person): Int = this.age.compareTo(other.age)
        }

        val array = arrayOf(
            Person("Alice", 30),
            Person("Bob", 25),
            Person("Charlie", 35)
        )

        insertionSort(array)

        assertTrue(array[0].age <= array[1].age && array[1].age <= array[2].age)
        assertEquals("Bob", array[0].name)
        assertEquals("Alice", array[1].name)
        assertEquals("Charlie", array[2].name)
    }
}
