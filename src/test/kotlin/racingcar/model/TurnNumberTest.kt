package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import racingcar.model.TurnNumber.Companion.MIN_TURN_NUMBER

class TurnNumberTest {
    @Test
    fun createTurnNumber_numberIsSmallerThanMinimum_thenThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException::class.java) {
            TurnNumber(number = NUMBER_SMALLER_THAN_MIN_TURN_NUMBER)
        }
    }

    @Test
    fun createTurnNumber_numberIsMinimum_successfullyCreated() {
        val turnNumber = TurnNumber(number = MIN_TURN_NUMBER)
        assertThat(turnNumber.number).isEqualTo(MIN_TURN_NUMBER)
    }

    @Test
    fun createTurnNumber_numberIsGreaterThanMinimum_successfullyCreated() {
        val turnNumber = TurnNumber(number = NUMBER_GREATER_THAN_MIN_TURN_NUMBER)
        assertThat(turnNumber.number).isEqualTo(NUMBER_GREATER_THAN_MIN_TURN_NUMBER)
    }


    companion object {
        private const val NUMBER_SMALLER_THAN_MIN_TURN_NUMBER = MIN_TURN_NUMBER - 1
        private const val NUMBER_GREATER_THAN_MIN_TURN_NUMBER = MIN_TURN_NUMBER + 1
    }
}