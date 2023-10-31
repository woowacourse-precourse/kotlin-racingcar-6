package racingcar.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {

    companion object {
        @JvmStatic
        fun provideCarNames(): List<Array<String>> {
            return listOf(
                arrayOf("AB##", "ABC"),
                arrayOf("A1B2", "ABC"),
                arrayOf("A   B", "ABC"),
                arrayOf("  AB", "ABC"),
                arrayOf("AB  ", "ABC"),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideCarNames")
    fun `자동차 이름에 문자 이외의 요소가 있을 때 예외 발생`(carName1: String, carName2: String) {
        val carNames = arrayListOf(carName1, carName2)
        val exception = assertThrows<IllegalArgumentException> {
            Validator(carNames, "5")
        }
        assertEquals("Car names must be alphabetic and have a length of 1 to 5 characters.", exception.message)
    }

    @Test
    fun `자동차 이름의 길이가 5보다 클 때 예외 발생`() {
        val carNames = arrayListOf("ABCDEF", "ABC")
        val exception = assertThrows<IllegalArgumentException> {
            Validator(carNames, "5")
        }
        assertEquals("Car names must be alphabetic and have a length of 1 to 5 characters.", exception.message)
    }

    @Test
    fun `자동차 이름이 중복될 때 예외 발생`() {
        val carNames = arrayListOf("ABC", "ABC")
        val exception = assertThrows<IllegalArgumentException> {
            Validator(carNames, "5")
        }
        assertEquals("Car names must not be duplicated.", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "숫자가아님"])
    fun `시도할 횟수가 양의 정수가 아닐 때 예외 발생`(count: String) {
        val carNames = arrayListOf("ABC", "DEF")
        val exception = assertThrows<IllegalArgumentException> {
            Validator(carNames, count)
        }
        assertEquals("Attempt count must be a positive integer.", exception.message)
    }

    @Test
    fun `자동차 이름으로 한글을 입력할 때`() {
        val carNames = arrayListOf("대한민국", "캐나다")
        assertDoesNotThrow {
            Validator(carNames, "5")
        }
    }
}
