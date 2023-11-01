package racingcar.view

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputParserTest {
    @Test
    fun validateCarNamesInput_withCommasSeparatedString_shouldBeOk() {
        // given
        val input = "a,b,c"
        val inputParser = InputParser()

        // when
        // then
        val createCarsDto = inputParser.parseToCreateCarsDto(input)
    }

    @Test
    fun validateCarNamesInput_withCommasSeparatedStringContainsEmptyString_shouldThrowException() {
        // given
        val input = "a,b,c,"
        val inputValidator = InputValidator()

        // when
        // then
        assertThatThrownBy { inputValidator.validateCarNamesInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("유효하지 않은 입력입니다. 차 이름은 ,로 구분해주세요.")
    }

    @Test
    fun validateCarNamesInput_withDigit_shouldBeOk() {
        // given
        val input1 = "1"
        val input2 = "123"
        val inputValidator = InputValidator()

        // when
        // then
        inputValidator.validateMaxRound(input1)
        inputValidator.validateMaxRound(input2)
    }

    @Test
    fun validateCarNamesInput_containsNotDigit_shouldThrowException() {
        // given
        val input1 = "1 "
        val input2 = "ab1"
        val inputValidator = InputValidator()

        // when
        // then
        assertThatThrownBy { inputValidator.validateMaxRound(input1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("유효하지 않은 입력입니다. 숫자를 입력해주세요.")

        assertThatThrownBy { inputValidator.validateMaxRound(input2) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("유효하지 않은 입력입니다. 숫자를 입력해주세요.")
    }
}