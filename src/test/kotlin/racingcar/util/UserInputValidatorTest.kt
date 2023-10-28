package racingcar.util

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("입력받은 값을 검증하는 UserInputValidator에서")
class UserInputValidatorTest {
    private val validator = UserInputValidator()

    @Test
    @DisplayName("시도 횟수가 양의 정수면 오류가 발생하지 않는다")
    fun inputInAttemptCountNormalInteger() {
        //given
        //when
        //then
        Assertions.assertThatNoException().isThrownBy { validator.validateNumberFormat("5") }
    }

    @Test
    @DisplayName("시도 횟수가 정수가 아닌 입력은 IllegalArgumentException이 발생한다")
    fun inputInAttemptCountNotInteger() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy { validator.validateNumberFormat("n") }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("시도 횟수가 양의 정수가 아닌 입력은 IllegalArgumentException이 발생한다")
    fun inputInAttemptCountNotPositiveInteger() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy { validator.validateNumberFormat("-5") }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("정상적인 이름들을 입력하면 오류가 발생하지 않는다")
    fun inputNormalCarNames() {
        //given
        val carNames = listOf("911", "718")
        //when
        //then
        Assertions.assertThatNoException().isThrownBy { validator.validateCarNames(carNames) }
    }

    @Test
    @DisplayName("공백의 이름 입력은 IllegalArgumentException이 발생한다")
    fun inputBlankCarNames() {
        //given
        val carNames = listOf("911", " ")
        //when
        //then
        Assertions.assertThatThrownBy { validator.validateCarNames(carNames) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("앞뒤에 공백이 있는 이름 입력은 IllegalArgumentException이 발생한다")
    fun inputCarNamesContainsBlankInFirstAndLast() {
        //given
        val carNames = listOf("911", " new ")
        //when
        //then
        Assertions.assertThatThrownBy { validator.validateCarNames(carNames) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }
}