package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BoardTest {

    private val board = Board.of(
        nameOfParticipants = listOf(CarName(CAR_NAME1), CarName(CAR_NAME2)),
        attempt = 4
    )
    private val car1 = CarName(CAR_NAME1)

    @Test
    @DisplayName("참가하지 않은 자동차의 이름으로 함수를 호출했을 때, 오류를 발생하는지")
    fun addScore_NotParticipants() {
        assertThatThrownBy { board.writeResult(CarName("dfs"), 2, 2) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Board.Error.InvalidName.message)
    }

    @Test
    fun addScore() {
        val currentAttempt = 1
        val currentScore = 1
        board.writeResult(car1, currentAttempt, currentScore)
        val (_, score) = board.getResultByAttempt(currentAttempt).first { (name, _) -> name == car1 }
        assertThat(score).isEqualTo(currentScore)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 5, -1])
    fun getResultByAttempt_Invalid(currentAttempt: Attempt) {
        assertThatThrownBy { board.getResultByAttempt(currentAttempt) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Board.Error.InvalidAttempt.message)
    }

    companion object {
        private const val CAR_NAME1 = "car1"
        private const val CAR_NAME2 = "car1"
    }
}