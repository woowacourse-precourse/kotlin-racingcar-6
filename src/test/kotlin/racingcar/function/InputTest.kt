package racingcar.function

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import racingcar.InputView.validateInputCarNames

class InputTest {
    @Test
    fun `자동차 목록 입력 - 정상 입력`() {
        val input = "jun,pobi,wow"
        val result = validateInputCarNames(input)
        assertEquals(result, listOf("jun", "pobi", "wow"))
    }

    @Test
    fun `자동차 목록 입력 - 빈 값 예외 처리`() {
        assertThrows<IllegalArgumentException> { validateInputCarNames("") }
    }

    @Test
    fun `자동차 목록 입력 - 이름 길이 예외 처리`() {
        val exception = assertThrows<IllegalArgumentException> { validateInputCarNames("hi,wow,junyong,name") }
        assertThat(exception.message).contains("junyong")
    }

    @Test
    fun `자동차 목록 입력 - 중복 이름 예외 처리`() {
        val exception = assertThrows<IllegalArgumentException> { validateInputCarNames("hi,wow,nice,wow") }
        assertThat(exception.message).contains("wow")
    }

    @Test
    fun `자동차 목록 입력 - 공백 포함 이름 예외 처리`() {
        val exception = assertThrows<IllegalArgumentException> { validateInputCarNames("hi,wow,j y") }
        assertThat(exception.message).contains("j y")
    }
}