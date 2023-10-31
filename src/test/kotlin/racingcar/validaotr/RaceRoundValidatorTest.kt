package racingcar.validaotr

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.validator.RaceRoundValidator

class RaceRoundValidatorTest {
    private val validator = RaceRoundValidator()

    @Test
    fun `이동 횟수에 숫자가 아닌 형식을 입력 시 예외 발생 테스트 1`() {
        val input = ""
        assertThrows<IllegalArgumentException> { validator.validate(input) }
    }

    @Test
    fun `이동 횟수에 숫자가 아닌 형식을 입력 시 예외 발생 테스트 2`() {
        val input = "123abc"
        assertThrows<IllegalArgumentException> { validator.validate(input) }
    }

    @Test
    fun `이동 횟수에 숫자가 아닌 형식을 입력 시 예외 발생 테스트 3`() {
        val input = "0.1"
        assertThrows<IllegalArgumentException> { validator.validate(input) }
    }

    @Test
    fun `이동 횟수에 1 미만의 숫자를 입력 시 예외 발생 테스트 1`() {
        val input = "0"
        assertThrows<IllegalArgumentException> { validator.validate(input) }
    }

    @Test
    fun `이동 횟수에 1 미만의 숫자를 입력 시 예외 발생 테스트 2`() {
        val input = "-10"
        assertThrows<IllegalArgumentException> { validator.validate(input) }
    }
}