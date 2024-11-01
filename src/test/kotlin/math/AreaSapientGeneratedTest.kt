
package math

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import kotlin.math.PI
import kotlin.math.pow

class AreaSapientGeneratedTest {

    @ParameterizedTest
    @CsvSource(
        "2.0, 3.0, 6.0",
        "1.5, 2.5, 3.75",
        "10.0, 10.0, 100.0"
    )
    fun testAreaOfARectangle(length: Double, width: Double, expectedArea: Double) {
        val area = areaOfARectangle(length, width)
        expectThat(area).isEqualTo(expectedArea)
    }

    @Test
    fun testAreaOfARectangleWithNegativeLength() {
        assertThrows<IllegalArgumentException> {
            areaOfARectangle(-1.0, 2.0)
        }
    }

    @Test
    fun testAreaOfARectangleWithNegativeWidth() {
        assertThrows<IllegalArgumentException> {
            areaOfARectangle(2.0, -1.0)
        }
    }

    @Test
    fun testAreaOfARectangleWithZeroLength() {
        assertThrows<IllegalArgumentException> {
            areaOfARectangle(0.0, 2.0)
        }
    }

    @Test
    fun testAreaOfARectangleWithZeroWidth() {
        assertThrows<IllegalArgumentException> {
            areaOfARectangle(2.0, 0.0)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "2.0, 4.0",
        "1.5, 2.25",
        "10.0, 100.0"
    )
    fun testAreaOfASquare(sideLength: Double, expectedArea: Double) {
        val area = areaOfASquare(sideLength)
        expectThat(area).isEqualTo(expectedArea)
    }

    @Test
    fun testAreaOfASquareWithNegativeSideLength() {
        assertThrows<IllegalArgumentException> {
            areaOfASquare(-1.0)
        }
    }

    @Test
    fun testAreaOfASquareWithZeroSideLength() {
        assertThrows<IllegalArgumentException> {
            areaOfASquare(0.0)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "2.0, 3.0, 3.0",
        "1.5, 2.5, 1.875",
        "10.0, 10.0, 50.0"
    )
    fun testAreaOfATriangle(base: Double, height: Double, expectedArea: Double) {
        val area = areaOfATriangle(base, height)
        expectThat(area).isEqualTo(expectedArea)
    }

    @Test
    fun testAreaOfATriangleWithNegativeBase() {
        assertThrows<IllegalArgumentException> {
            areaOfATriangle(-1.0, 2.0)
        }
    }

    @Test
    fun testAreaOfATriangleWithNegativeHeight() {
        assertThrows<IllegalArgumentException> {
            areaOfATriangle(2.0, -1.0)
        }
    }

    @Test
    fun testAreaOfATriangleWithZeroBase() {
        assertThrows<IllegalArgumentException> {
            areaOfATriangle(0.0, 2.0)
        }
    }

    @Test
    fun testAreaOfATriangleWithZeroHeight() {
        assertThrows<IllegalArgumentException> {
            areaOfATriangle(2.0, 0.0)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "1.0, 3.141592653589793",
        "2.0, 12.566370614359172",
        "0.5, 0.7853981633974483"
    )
    fun testAreaOfACircle(radius: Double, expectedArea: Double) {
        val area = areaOfACircle(radius)
        expectThat(area).isEqualTo(expectedArea)
    }

    @Test
    fun testAreaOfACircleWithNegativeRadius() {
        assertThrows<IllegalArgumentException> {
            areaOfACircle(-1.0)
        }
    }

    @Test
    fun testAreaOfACircleWithZeroRadius() {
        assertThrows<IllegalArgumentException> {
            areaOfACircle(0.0)
        }
    }
}
