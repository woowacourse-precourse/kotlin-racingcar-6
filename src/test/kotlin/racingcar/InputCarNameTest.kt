package racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.validation.InputValidation

class InputCarNameTest {
    @Test
    fun `자동차_이름_리스트_검증`() {
        val inputValidation = InputValidation()
        val names = listOf("자동차1", "자동차2", "자동차3")
        val validatedNames = inputValidation.validateCarNames(names)
        Assertions.assertEquals(names, validatedNames)
    }

    @Test
    fun `자동차_이름_리스트_길이_검증`() {
        val inputValidation = InputValidation()
        val names = listOf("자동차1", "자동차2", "자동차3", "자동차4444")
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            inputValidation.validateCarNames(names)
        }
    }
}