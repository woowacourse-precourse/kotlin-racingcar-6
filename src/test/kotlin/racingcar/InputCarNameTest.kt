package racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.util.COMMA
import racingcar.validation.InputValidation

class InputCarNameTest {
    private val inputValidation = InputValidation()

    @Test
    fun `자동차_이름_리스트_검증`() {
        val names = listOf("자동차1", "자동차2", "자동차3")
        val validatedNames = inputValidation.validateCarNames(names)
        Assertions.assertEquals(names, validatedNames)
    }

    @Test
    fun `자동차_이름_리스트_길이_검증`() {
        val names = listOf("자동차1", "자동차2", "자동차3", "자동차4444")
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            inputValidation.validateCarNames(names)
        }
    }

    @Test
    fun `자동차_이름_구분자_분리_테스트`() {
        val input = "Car1,Car2,Car3"
        val expectedNames = listOf("Car1", "Car2", "Car3")

        val carNames = inputValidation.validateCarNames(input.split(COMMA))
        assertEquals(expectedNames, carNames)
    }
}