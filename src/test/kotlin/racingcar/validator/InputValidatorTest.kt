package racingcar.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {
    @Test
    fun `validateCarNameList에서 정상 출력`() {
        val validator = InputValidator()
        validator.validateCarNameList(listOf("123", "324"))
    }

    @Test
    fun `validateCarNameList에서 비어있으면 오류가 발생합니다`() {
        val validator = InputValidator()
        assertThrows<IllegalArgumentException> {
            validator.validateCarNameList(listOf())
        }
    }

    @Test
    fun `validatePlayCount에서 정상 출력`() {
        val validator = InputValidator()
        validator.validatePlayCount(1)
    }

    @Test
    fun `validatePlayCount에서 양수가 아니면 오류가 발생합니다`() {
        val validator = InputValidator()
        assertThrows<IllegalArgumentException> {
            validator.validatePlayCount(0)
        }
    }
}