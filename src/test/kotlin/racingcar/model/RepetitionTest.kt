package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RepetitionTest {
    @ParameterizedTest
    @ValueSource(strings = ["a", " ", "*", "!"])
    @DisplayName("Repetition(init): checkDigitRange(special char)")
    fun `반복 횟수가 숫자 인지 검증`(inputCount: String) {
        val exception = assertThrows<IllegalArgumentException> {
            Repetition(inputCount)
        }
        assertThat(Repetition.ONLY_DIGIT).contains(exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0"])
    @DisplayName("Repetition(init): checkDigitRange(-Int, Zero)")
    fun `반복 횟수가 숫자라면 1이상 인지 검증`(inputCount: String) {
        val exception = assertThrows<IllegalArgumentException> {
            Repetition(inputCount)
        }
        assertEquals(Repetition.DIGIT_THAN_ONE, exception.message)
    }


    @ParameterizedTest
    @ValueSource(strings = ["10", "1000", "100000"])
    @DisplayName("Repetition(init): checkDigitRange(+Int)")
    fun `반복 횟수가 자연수일 때, 잘 동작하는지`(inputCount: String) {
        assertDoesNotThrow {
            Repetition(inputCount)
        }
    }
}