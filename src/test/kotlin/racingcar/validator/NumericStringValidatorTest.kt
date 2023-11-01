package racingcar.validator

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumericStringValidatorTest {
    @Test
    fun `문자열의 모든 문자가 숫자여야함`() {
        val numericString = "123"
        val numericWithLetterString = "123a"
        val validator: StringValidator = NumericStringValidator()

        val validResult = runCatching { validator.validate(numericString) }.exceptionOrNull()
        val inValidResult = runCatching { validator.validate(numericWithLetterString) }.exceptionOrNull()

        assertThat(validResult).isNull()
        assertThat(inValidResult).hasSameClassAs(IllegalArgumentException())
        assertThat(inValidResult!!.message).isEqualTo("문자열은 숫자여야 합니다")
        assertThrows<IllegalArgumentException>("문자열은 숫자여야 합니다") {
            validator.validate(numericWithLetterString)
        }
    }

    @Test
    fun `0은 유효하지 않다`() {
        val zeroString = "0"
        val validator: StringValidator = NumericStringValidator()

        assertThrows<IllegalArgumentException>("0은 유효하지 않습니다") {
            validator.validate(zeroString)
        }
    }
}