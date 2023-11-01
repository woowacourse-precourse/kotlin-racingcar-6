package mytest

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.Constants

class MyTest {

    @Test
    fun `차 이름 최소 1자 이상 확인`() {
        val inputCar = "abc,,bcd,def"
        val result = inputCar.split(",")
        assertThrows<IllegalArgumentException> {
            require(!result.any { it.isEmpty() })
        }
    }

    @Test
    fun `차 이름 5자 이하 확인`() {
        val inputCar = "abc,abcd,abcde,abcdef"
        val result = inputCar.split(",")
        assertThrows<IllegalArgumentException> {
            require(!result.any { it.length > Constants.MAX_CAR_LENGTH })
        }
    }

    @Test
    fun `시도 횟수 입력은 항상 숫자`() {
        val inputAttempt = "3p7"
        assertThrows<IllegalArgumentException> {
            require(inputAttempt.toIntOrNull() != null)
        }
    }
}