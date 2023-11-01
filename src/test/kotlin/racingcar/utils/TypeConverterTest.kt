package racingcar.utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.game.Car
import racingcar.utils.TypeConverter.stringToCarList
import racingcar.utils.TypeConverter.stringToInt

class TypeConverterTest {
    @Test
    fun `String에서 CarList 자료형 변환`() {
        val input = "aaa, vvv, ccc, ddd"
        val result = stringToCarList(input)
        assertEquals(result, listOf(Car("aaa"), Car("vvv"), Car("ccc"), Car("ddd")))
    }

    @Test
    fun `String에서 Int 자료형 변환 - 정상 입력`() {
        val input = "001009"
        val result = stringToInt(input)
        assertEquals(result, 1009)
    }

    @Test
    fun `String에서 Int 자료형 변환 - 빈 값 예외 처리`() {
        assertThrows<IllegalArgumentException> { stringToInt("") }
    }

    @Test
    fun `String에서 Int 자료형 변환 - 숫자 외 입력 예외 처리`() {
        assertThrows<IllegalArgumentException> { stringToInt("abcd1004") }
    }

    @Test
    fun `String에서 Int 자료형 변환 - 범위 초과 예외 처리`() {
        assertThrows<IllegalArgumentException> { stringToInt("2147483648") }
    }
}