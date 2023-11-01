package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class ExceptionTest {
    @Test
    fun `이름이 문자나 숫자로 구성되지 않으면 예외가 발생한다`() {
        val nameList = listOf("pobi","@woni","po bi" )
        assertThrows<IllegalArgumentException>(Const.EXCEPTION_WRONG_NAME){ processExceptionCar(nameList) }
    }

    @Test
    fun `이름의 길이가 1이상 5이하가 아니면 예외가 발생한다`() {
        val nameList = listOf("woni", "ppoobb", "")
        assertThrows<IllegalArgumentException>(Const.EXCEPTION_LENGTH_NAME) { processExceptionCar(nameList) }
    }

    @Test
    fun `중복된 이름이 있으면 예외가 발생한다`() {
        val nameList = listOf("pobi","woni","jun","woni")
        assertThrows<IllegalArgumentException>(Const.EXCEPTION_DUP_NAME) { processExceptionCar(nameList) }
    }

    @Test
    fun `횟수 입력이 0이면 예외가 발생한다`() {
        val count = "0"
        assertThrows<IllegalArgumentException>(Const.EXCEPTION_WRONG_NUMBER) { processExceptionCount(count) }
    }

    @Test
    fun `횟수 입력에 숫자가 아닌 입력이 있으면 예외가 발생한다`() {
        val count = "-2"
        assertThrows<IllegalArgumentException>(Const.EXCEPTION_NOT_NUMBER) { processExceptionCount(count) }
    }
}