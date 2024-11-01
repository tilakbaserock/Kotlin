
package sort

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class SelectionSortSapientGeneratedTest {

    @Test
    fun `test selectionSort with integer array`() {
        val array = arrayOf(64, 34, 25, 12, 22, 11, 90)
        selectionSort(array)
        assertArrayEquals(arrayOf(11, 12, 22, 25, 34, 64, 90), array)
    }

    @Test
    fun `test selectionSort with string array`() {
        val array = arrayOf("banana", "apple", "cherry", "date")
        selectionSort(array)
        assertArrayEquals(arrayOf("apple", "banana", "cherry", "date"), array)
    }

    @Test
    fun `test selectionSort with empty array`() {
        val array = emptyArray<Int>()
        selectionSort(array)
        assertTrue(array.isEmpty())
    }

    @Test
    fun `test selectionSort with single element array`() {
        val array = arrayOf(1)
        selectionSort(array)
        assertArrayEquals(arrayOf(1), array)
    }

    @Test
    fun `test selectionSort with already sorted array`() {
        val array = arrayOf(1, 2, 3, 4, 5)
        selectionSort(array)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), array)
    }

    @Test
    fun `test selectionSort with reverse sorted array`() {
        val array = arrayOf(5, 4, 3, 2, 1)
        selectionSort(array)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), array)
    }

    @ParameterizedTest
    @MethodSource("provideArrays")
    fun `test selectionSort with various arrays`(input: Array<Int>, expected: Array<Int>) {
        selectionSort(input)
        assertArrayEquals(expected, input)
    }

    companion object {
        @JvmStatic
        fun provideArrays(): Stream<Array<Array<Int>>> = Stream.of(
            arrayOf(arrayOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3), arrayOf(1, 1, 2, 3, 3, 4, 5, 5, 6, 9)),
            arrayOf(arrayOf(1, 1, 1, 1), arrayOf(1, 1, 1, 1)),
            arrayOf(arrayOf(Int.MAX_VALUE, 0, Int.MIN_VALUE), arrayOf(Int.MIN_VALUE, 0, Int.MAX_VALUE))
        )
    }

    @Test
    fun `test selectionSort with custom comparable class`() {
        data class Person(val name: String, val age: Int) : Comparable<Person> {
            override fun compareTo(other: Person): Int = this.age.compareTo(other.age)
        }

        val array = arrayOf(
            Person("Alice", 30),
            Person("Bob", 25),
            Person("Charlie", 35)
        )

        selectionSort(array)

        assertEquals("Bob", array[0].name)
        assertEquals(25, array[0].age)
        assertEquals("Alice", array[1].name)
        assertEquals(30, array[1].age)
        assertEquals("Charlie", array[2].name)
        assertEquals(35, array[2].age)
    }

//    @Test
//    fun `test selectionSort with null elements throws exception`() {
//        val array: Array<String?> = arrayOf("a", null, "b")
//        assertThrows(NullPointerException::class.java) {
//            selectionSort(array)
//        }
//    }
}
