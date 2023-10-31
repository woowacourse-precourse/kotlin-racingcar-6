package racingcar.validator

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class StringLengthValidatorTest {
    @Test
    fun `문자열을 ,로 split 하였을 때 모든 문자열의 길이가 1이상 5이하여야 한다`() {
        val validString = "murjune,pobi"
        val inValidString = "june,pobi"
        val stringLengthValidator: StringValidator = StringLengthValidator()

        val result1 = runCatching { stringLengthValidator.validate(validString) }.exceptionOrNull()
        val result2 = runCatching { stringLengthValidator.validate(inValidString) }.exceptionOrNull()

        assertThat(result1).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(result1!!.message).isEqualTo("Car 이름의 길이가 1글자 이상 5글자 이하여야 합니다")
        assertThat(result2).isNull()
    }
}