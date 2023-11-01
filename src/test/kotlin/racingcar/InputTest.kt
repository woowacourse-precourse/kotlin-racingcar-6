package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.utils.Validations

class InputTest {
    @Test
    fun `자동차 이름이 5자 이상일 때 예외 발생`() {
        val input = "woowatech"
        assertThrows<IllegalArgumentException>{
            Validations.inputCarName(input)
        }
    }

    @Test
    fun `자동차 이름이 공백일 때 예외 발생`() {
        val input = "woo,wa,,tech, ,course"
        assertThrows<IllegalArgumentException>{
            Validations.inputCarName(input)
        }
    }

    @Test
    fun `시도 횟수가 문자열일 때 예외 발생`() {
        val input = "5번"
        assertThrows<IllegalArgumentException>{
            Validations.inputTrial(input)
        }
    }

    @Test
    fun `시도 횟수가 공백일 때 예외 발생`() {
        val input = " "
        assertThrows<IllegalArgumentException>{
            Validations.inputTrial(input)
        }
    }
}