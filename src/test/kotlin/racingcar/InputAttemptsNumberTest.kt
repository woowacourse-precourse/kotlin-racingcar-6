package racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.validation.InputValidation

class InputAttemptsNumberTest {
    @Test
    fun `시도횟수_검증`() {
        val inputValidation = InputValidation()
        val validAttempt = 5
        val validatedAttempt = inputValidation.validateAttemptsNumber(validAttempt)
        Assertions.assertEquals(validAttempt, validatedAttempt)
    }

    @Test
    fun `시도횟수_음수인경우_검증`() {
        val inputValidation = InputValidation()
        val invalidAttempt = -1
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            inputValidation.validateAttemptsNumber(invalidAttempt)
        }
    }
}