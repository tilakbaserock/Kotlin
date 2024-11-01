
package search

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.util.stream.Stream

class BinarySearchSapientGeneratedTest {

    @Test
    fun testBinarySearchWithIntegerArray() {
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        expectThat(binarySearch(array, 5)).isEqualTo(4)
        expectThat(binarySearch(array, 1)).isEqualTo(0)
        expectThat(binarySearch(array, 10)).isEqualTo(9)
        expectThat(binarySearch(array, 11)).isEqualTo(-1)
        expectThat(binarySearch(array, 0)).isEqualTo(-1)
    }

    @Test
    fun testBinarySearchWithStringArray() {
        val array = arrayOf("apple", "banana", "cherry", "date", "elderberry")
        expectThat(binarySearch(array, "cherry")).isEqualTo(2)
        expectThat(binarySearch(array, "apple")).isEqualTo(0)
        expectThat(binarySearch(array, "elderberry")).isEqualTo(4)
        expectThat(binarySearch(array, "fig")).isEqualTo(-1)
        expectThat(binarySearch(array, "aardvark")).isEqualTo(-1)
    }

    @ParameterizedTest
    @MethodSource("provideArraysAndKeys")
    fun testBinarySearchWithVariousArrays(array: Array<Int>, key: Int, expectedIndex: Int) {
        expectThat(binarySearch(array, key)).isEqualTo(expectedIndex)
    }

    @Test
    fun testBinarySearchWithSingleElementArray() {
        val array = arrayOf(42)
        expectThat(binarySearch(array, 42)).isEqualTo(0)
        expectThat(binarySearch(array, 41)).isEqualTo(-1)
        expectThat(binarySearch(array, 43)).isEqualTo(-1)
    }

    @Test
    fun testBinarySearchWithEmptyArray() {
        val array = emptyArray<Int>()
        expectThat(binarySearch(array, 1)).isEqualTo(-1)
    }

    @Test
    fun testBinarySearchWithDuplicateElements() {
        val array = arrayOf(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)
        expectThat(binarySearch(array, 2)).isEqualTo(1) // Returns the first occurrence
        expectThat(binarySearch(array, 3)).isEqualTo(3) // Returns the first occurrence
        expectThat(binarySearch(array, 4)).isEqualTo(6) // Returns the first occurrence
    }

//    @Test
//    fun testBinarySearchWithNullableArray() {
//        val array = arrayOf<Int?>(1, 2, 3, null, 5)
//        expectThat(binarySearch(array.filterNotNull().toTypedArray(), 3)).isEqualTo(2)
//        expectThat(binarySearch(array.filterNotNull().toTypedArray(), 4)).isEqualTo(-1)
//    }

    companion object {
        @JvmStatic
        fun provideArraysAndKeys(): Stream<Arguments> = Stream.of(
            Arguments.of(arrayOf(1, 3, 5, 7, 9), 5, 2),
            Arguments.of(arrayOf(1, 3, 5, 7, 9), 1, 0),
            Arguments.of(arrayOf(1, 3, 5, 7, 9), 9, 4),
            Arguments.of(arrayOf(1, 3, 5, 7, 9), 4, -1),
            Arguments.of(arrayOf(1, 3, 5, 7, 9), 10, -1),
            Arguments.of(arrayOf(1, 3, 5, 7, 9), 0, -1)
        )
    }
}
