package racingcar

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test

class InputTest {
    val validate = InputValidate()
    @Test
    fun `이름이 5글자 이상인 경우`() {
        val carName: List<String> = listOf("pobi123")
        assertThrows<IllegalArgumentException> { validate.validateCarNames(carName) }
    }

    @Test
    fun `이름에 공백이 있는 경우`() {
        val carName: List<String> = listOf(" ")
        assertThrows<IllegalArgumentException> { validate.validateCarNames(carName) }
    }

    @Test
    fun `이름이 중복되는 경우`() {
        val carName: List<String> = listOf("pobi,pobi")
        assertThrows<IllegalArgumentException> { validate.validateCarNames(carName) }
    }

    @Test
    fun `자동차가 1개만 입력되는 경우`() {
        val carName: List<String> = listOf("pobi")
        assertThrows<IllegalArgumentException> { validate.validateCarNames(carName) }
    }

    @Test
    fun `시도 횟수가 자연수가 아닌 정수인 경우`() {
        val attempts = "-1"
        assertThrows<IllegalArgumentException> { validate.validateAttempts(attempts) }
    }

    @Test
    fun `시도 횟수에 숫자가 아닌 값이 포함된 경우`() {
        val attempts = "attempts12"
        assertThrows<IllegalArgumentException> { validate.validateAttempts(attempts) }
    }
}