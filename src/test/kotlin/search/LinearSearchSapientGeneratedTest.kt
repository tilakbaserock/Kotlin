
package search

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class LinearSearchSapientGeneratedTest {

    @Test
    fun testLinearSearchWithIntegerArray() {
        val array = arrayOf(1, 3, 5, 7, 9)
        expectThat(linearSearch(array, 5)).isEqualTo(2)
        expectThat(linearSearch(array, 1)).isEqualTo(0)
        expectThat(linearSearch(array, 9)).isEqualTo(4)
        expectThat(linearSearch(array, 10)).isEqualTo(-1)
    }

    @Test
    fun testLinearSearchWithStringArray() {
        val array = arrayOf("apple", "banana", "cherry", "date")
        expectThat(linearSearch(array, "cherry")).isEqualTo(2)
        expectThat(linearSearch(array, "apple")).isEqualTo(0)
        expectThat(linearSearch(array, "date")).isEqualTo(3)
        expectThat(linearSearch(array, "grape")).isEqualTo(-1)
    }

    @Test
    fun testLinearSearchWithEmptyArray() {
        val array = emptyArray<Int>()
        expectThat(linearSearch(array, 5)).isEqualTo(-1)
    }

    @Test
    fun testLinearSearchWithSingleElementArray() {
        val array = arrayOf(42)
        expectThat(linearSearch(array, 42)).isEqualTo(0)
        expectThat(linearSearch(array, 43)).isEqualTo(-1)
    }

    @ParameterizedTest
    @MethodSource("provideArraysAndKeys")
    fun testLinearSearchParameterized(array: Array<Int>, key: Int, expectedIndex: Int) {
        expectThat(linearSearch(array, key)).isEqualTo(expectedIndex)
    }

    companion object {
        @JvmStatic
        fun provideArraysAndKeys() = listOf(
            Arguments.of(arrayOf(1, 2, 3, 4, 5), 3, 2),
            Arguments.of(arrayOf(1, 2, 3, 4, 5), 6, -1),
            Arguments.of(arrayOf(5, 4, 3, 2, 1), 5, 0),
            Arguments.of(arrayOf(5, 4, 3, 2, 1), 1, 4)
        )
    }

    @Test
    fun testLinearSearchWithCustomComparable() {
        data class Person(val name: String, val age: Int) : Comparable<Person> {
            override fun compareTo(other: Person): Int = this.age.compareTo(other.age)
        }

        val array = arrayOf(
            Person("Alice", 25),
            Person("Bob", 30),
            Person("Charlie", 35)
        )

        expectThat(linearSearch(array, Person("David", 30))).isEqualTo(1)
        expectThat(linearSearch(array, Person("Eve", 40))).isEqualTo(-1)
    }

    @Test
    fun testLinearSearchImplDirectly() {
        val array = arrayOf(2, 4, 6, 8, 10)
        expectThat(linearSearchImpl(array, 6)).isEqualTo(2)
        expectThat(linearSearchImpl(array, 11)).isEqualTo(-1)
    }

//    @Test
//    fun testLinearSearchWithNullableArray() {
//        val array = arrayOf<Int?>(1, null, 3, null, 5)
//        expectThat(linearSearch(array.filterNotNull().toTypedArray(), 3)).isEqualTo(1)
//        expectThat(linearSearch(array.filterNotNull().toTypedArray(), 4)).isEqualTo(-1)
//    }
}
