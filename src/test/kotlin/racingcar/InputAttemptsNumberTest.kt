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
}