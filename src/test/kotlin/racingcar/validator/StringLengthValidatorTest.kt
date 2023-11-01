package racingcar.validator

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringLengthValidatorTest {
    @Test
    fun `문자열을 ,로 split 하였을 때 모든 문자열의 길이가 1이상 5이하여야 한다`() {
        val inValidString = "murjune,pobi"
        val validString = "june,pobi"
        val stringLengthValidator: StringValidator = StringLengthValidator()

        val inValidResult = runCatching {
            stringLengthValidator.validate(inValidString)
        }.exceptionOrNull()
        val validResult = runCatching {
            stringLengthValidator.validate(validString)
        }.exceptionOrNull()

        assertThat(inValidResult).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(inValidResult!!.message).isEqualTo("문자열의 길이가 1글자 이상 5글자 이하여야 합니다")
        assertThat(validResult).isNull()
    }

    @Test
    fun `공백 문자열은 유효하지 않다`() {
        val blankString = "  "
        val stringLengthValidator: StringValidator = StringLengthValidator()

        assertThrows<IllegalArgumentException>("문자열의 길이가 1글자 이상 5글자 이하여야 합니다") {
            stringLengthValidator.validate(blankString)
        }
    }
}