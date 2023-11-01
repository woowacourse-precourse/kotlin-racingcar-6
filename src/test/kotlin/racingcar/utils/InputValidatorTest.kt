package racingcar.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import racingcar.game.Car
import racingcar.utils.InputValidator.validateInputCarNames
import racingcar.utils.InputValidator.validateInputRoundCount

class InputValidatorTest {
    @Test
    fun `자동차 목록 입력 검증 - 정상 입력`() {
        val input = listOf(Car("jun"), Car("pobi"), Car("wow"))
        validateInputCarNames(input)
        assertEquals(input, listOf(Car("jun"), Car("pobi"), Car("wow")))
    }

    @Test
    fun `자동차 목록 입력 검증 - 빈 값 예외 처리`() {
        val input = listOf(Car(""))
        assertThrows<IllegalArgumentException> { validateInputCarNames(input) }
    }

    @Test
    fun `자동차 목록 입력 검증 - 이름 길이 예외 처리`() {
        val input = listOf(Car("hi"), Car("wow"), Car("junyong"), Car("name"))
        val exception = assertThrows<IllegalArgumentException> { validateInputCarNames(input) }
        assertThat(exception.message).contains("junyong")
    }

    @Test
    fun `자동차 목록 입력 검증 - 중복 이름 예외 처리`() {
        val input = listOf(Car("hi"), Car("wow"), Car("nice"), Car("wow"))
        val exception = assertThrows<IllegalArgumentException> { validateInputCarNames(input) }
        assertThat(exception.message).contains("wow")
    }

    @Test
    fun `자동차 목록 입력 검증 - 공백 포함 이름 예외 처리`() {
        val input = listOf(Car("hi"), Car("wow"), Car("j y"))
        val exception = assertThrows<IllegalArgumentException> { validateInputCarNames(input) }
        assertThat(exception.message).contains("j y")
    }

    @Test
    fun `이동할 횟수 입력 검증 - 정상 입력`() {
        val input = 10
        validateInputRoundCount(input)
        assertEquals(input, 10)
    }

    @Test
    fun `이동할 횟수 입력 검증 - 1회 미만 예외 처리`() {
        assertThrows<IllegalArgumentException> { validateInputRoundCount(0) }
    }
}