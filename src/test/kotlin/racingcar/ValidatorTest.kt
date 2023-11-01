package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    @Test
    fun `입력값이 빈 문자열인 경우 예외 발생`() {
        val input = ""

        val exception = assertThrows<IllegalArgumentException> { Validator.validateInput(input) }

        assertThat(exception.message).isEqualTo("입력이 잘못되었어요.")
    }

    @Test
    fun `입력값이 빈 문자열이 아닌 경우 예외 발생하지 않음`() {
        val input = "테스트"

        assertDoesNotThrow { Validator.validateInput(input) }
    }

    @Test
    fun `차 이름이 빈 문자열일 경우 예외 발생`() {
        val carName = ""

        val exception = assertThrows<IllegalArgumentException> { Validator.validateCarName(carName) }

        assertThat(exception.message).isEqualTo("자동차 이름을 잘못 입력했어요.")
    }

    @Test
    fun `차 이름이 빈 문자열일 아닌 경우 예외 발생하지 않음`() {
        val carName = "abc"

        assertDoesNotThrow { Validator.validateCarName(carName) }
    }

    @Test
    fun `차 이름이 MAX_NAME_LENGTH 초과한 경우 예외 발생`() {
        val carName = "abcdef"

        val exception = assertThrows<IllegalArgumentException> { Validator.validateCarName(carName) }

        assertThat(exception.message).isEqualTo("자동차 이름은 ${MAX_NAME_LENGTH}자 이하로 입력해주세요.")
    }

    @Test
    fun `차 이름이 MAX_NAME_LENGTH 이하인 경우 예외 발생하지 않음`() {
        val carName = "abc"

        assertDoesNotThrow { Validator.validateCarName(carName) }
    }

    @Test
    fun `잘못된 이동 횟수 입력값에 대해 예외 발생`() {
        val moveCount = "1 2"

        val exception = assertThrows<IllegalArgumentException> { Validator.validateMoveCountInput(moveCount) }

        assertThat(exception.message).isEqualTo("이동 횟수는 숫자로 입력해주세요.")
    }

    @Test
    fun `올바른 이동 횟수 입력값에 대해 예외 발생하지 않음`() {
        val moveCount = "1"

        assertDoesNotThrow { Validator.validateMoveCountInput(moveCount) }
    }
}