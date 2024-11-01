
package sort

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class BubbleSortSapientGeneratedTest {

    @Test
    fun `test bubbleSort with integer array`() {
        val array = arrayOf(5, 2, 8, 12, 1, 6)
        bubbleSort(array)
        assertArrayEquals(arrayOf(1, 2, 5, 6, 8, 12), array)
    }

    @Test
    fun `test bubbleSort with string array`() {
        val array = arrayOf("banana", "apple", "cherry", "date")
        bubbleSort(array)
        assertArrayEquals(arrayOf("apple", "banana", "cherry", "date"), array)
    }

    @Test
    fun `test bubbleSort with empty array`() {
        val array = emptyArray<Int>()
        bubbleSort(array)
        assertArrayEquals(emptyArray(), array)
    }

    @Test
    fun `test bubbleSort with single element array`() {
        val array = arrayOf(1)
        bubbleSort(array)
        assertArrayEquals(arrayOf(1), array)
    }

    @Test
    fun `test bubbleSort with already sorted array`() {
        val array = arrayOf(1, 2, 3, 4, 5)
        bubbleSort(array)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), array)
    }

    @Test
    fun `test bubbleSort with reverse sorted array`() {
        val array = arrayOf(5, 4, 3, 2, 1)
        bubbleSort(array)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), array)
    }

    @Test
    fun `test bubbleSort with duplicate elements`() {
        val array = arrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5)
        bubbleSort(array)
        assertArrayEquals(arrayOf(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9), array)
    }

    @ParameterizedTest
    @MethodSource("provideArraysForSorting")
    fun `test bubbleSort with various arrays`(input: Array<Int>, expected: Array<Int>) {
        bubbleSort(input)
        assertArrayEquals(expected, input)
    }

    companion object {
        @JvmStatic
        fun provideArraysForSorting(): Stream<Array<Array<Int>>> = Stream.of(
            arrayOf(arrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5), arrayOf(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9)),
            arrayOf(arrayOf(5, 4, 3, 2, 1), arrayOf(1, 2, 3, 4, 5)),
            arrayOf(arrayOf(1, 2, 3, 4, 5), arrayOf(1, 2, 3, 4, 5)),
            arrayOf(arrayOf(1), arrayOf(1)),
            arrayOf(arrayOf(), arrayOf())
        )
    }

    @Test
    fun `test swapElements`() {
        val array = arrayOf(1, 2, 3, 4, 5)
        swapElements(array, 1, 3)
        assertArrayEquals(arrayOf(1, 4, 3, 2, 5), array)
    }

    @Test
    fun `test swapElements with same index`() {
        val array = arrayOf(1, 2, 3, 4, 5)
        swapElements(array, 2, 2)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), array)
    }

    @Test
    fun `test swapElements with edge indexes`() {
        val array = arrayOf(1, 2, 3, 4, 5)
        swapElements(array, 0, 4)
        assertArrayEquals(arrayOf(5, 2, 3, 4, 1), array)
    }

    @Test
    fun `test bubbleSort with custom comparable class`() {
        data class Person(val name: String, val age: Int) : Comparable<Person> {
            override fun compareTo(other: Person): Int = this.age.compareTo(other.age)
        }

        val array = arrayOf(
            Person("Alice", 30),
            Person("Bob", 25),
            Person("Charlie", 35),
            Person("David", 20)
        )

        bubbleSort(array)

        assertTrue(array[0].age <= array[1].age)
        assertTrue(array[1].age <= array[2].age)
        assertTrue(array[2].age <= array[3].age)

        assertEquals("David", array[0].name)
        assertEquals("Bob", array[1].name)
        assertEquals("Alice", array[2].name)
        assertEquals("Charlie", array[3].name)
    }
}
