
package sort

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.random.Random

class HeapSortSapientGeneratedTest {

    @Test
    fun testHeapSortWithEmptyArray() {
        val emptyArray = emptyArray<Int>()
        heapSort(emptyArray)
        assertTrue(emptyArray.isEmpty())
    }

    @Test
    fun testHeapSortWithSingleElement() {
        val singleElementArray = arrayOf(1)
        heapSort(singleElementArray)
        assertArrayEquals(arrayOf(1), singleElementArray)
    }

    @ParameterizedTest
    @MethodSource("provideSortTestCases")
    fun testHeapSortWithVariousArrays(input: Array<Int>, expected: Array<Int>) {
        heapSort(input)
        assertArrayEquals(expected, input)
    }

    @Test
    fun testHeapSortWithReverseSortedArray() {
        val reverseSortedArray = arrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
        heapSort(reverseSortedArray)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), reverseSortedArray)
    }

    @Test
    fun testHeapSortWithAlreadySortedArray() {
        val sortedArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        heapSort(sortedArray)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), sortedArray)
    }

    @Test
    fun testHeapSortWithDuplicateElements() {
        val arrayWithDuplicates = arrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5)
        heapSort(arrayWithDuplicates)
        assertArrayEquals(arrayOf(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9), arrayWithDuplicates)
    }

    @Test
    fun testHeapSortWithNegativeNumbers() {
        val arrayWithNegatives = arrayOf(-5, 1, -3, 2, -4, 0)
        heapSort(arrayWithNegatives)
        assertArrayEquals(arrayOf(-5, -4, -3, 0, 1, 2), arrayWithNegatives)
    }

    @Test
    fun testHeapSortWithLargeArray() {
        val largeArray = Array(10000) { Random.nextInt(0, 10000) }
        val sortedCopy = largeArray.sortedArray()
        heapSort(largeArray)
        assertArrayEquals(sortedCopy, largeArray)
    }

    @Test
    fun testHeapSortWithStrings() {
        val stringArray = arrayOf("banana", "apple", "cherry", "date")
        heapSort(stringArray)
        assertArrayEquals(arrayOf("apple", "banana", "cherry", "date"), stringArray)
    }

    @Test
    fun testHeapSortWithCustomComparable() {
        data class Person(val name: String, val age: Int) : Comparable<Person> {
            override fun compareTo(other: Person): Int = this.age.compareTo(other.age)
        }

        val personArray = arrayOf(
            Person("Alice", 30),
            Person("Bob", 25),
            Person("Charlie", 35),
            Person("David", 28)
        )

        heapSort(personArray)

        val expectedArray = arrayOf(
            Person("Bob", 25),
            Person("David", 28),
            Person("Alice", 30),
            Person("Charlie", 35)
        )

        assertArrayEquals(expectedArray, personArray)
    }

    @Test
    fun testMaxheapify() {
        val array = arrayOf(4, 10, 3, 5, 1)
        maxheapify(array, array.size, 0)
        assertArrayEquals(arrayOf(10, 5, 3, 4, 1), array)
    }

    companion object {
        @JvmStatic
        fun provideSortTestCases(): Stream<Array<Array<Int>>> = Stream.of(
            arrayOf(arrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5), arrayOf(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9)),
            arrayOf(arrayOf(5, 2, 9, 1, 7, 6, 3), arrayOf(1, 2, 3, 5, 6, 7, 9)),
            arrayOf(arrayOf(1, 1, 1, 1), arrayOf(1, 1, 1, 1)),
            arrayOf(arrayOf(100, 50, 75, 25), arrayOf(25, 50, 75, 100))
        )
    }
}
