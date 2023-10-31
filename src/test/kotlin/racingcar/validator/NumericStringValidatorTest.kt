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

        val result1 = runCatching { validator.validate(numericString) }.exceptionOrNull()
        val result2 = runCatching { validator.validate(numericWithLetterString) }.exceptionOrNull()

        assertThat(result1).isNull()
        assertThat(result2).hasSameClassAs(IllegalArgumentException())
        assertThat(result2!!.message).isEqualTo("문자열은 숫자여야 합니다")
        assertThrows<IllegalArgumentException>("문자열은 숫자여야 합니다") {
            validator.validate(numericWithLetterString)
        }
    }
}