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
        round = Round(4)
    )
    private val car1 = CarName(CAR_NAME1)

    @Test
    @DisplayName("참가하지 않은 자동차의 이름으로 함수를 호출했을 때, 오류를 발생하는지")
    fun addScore_NotParticipants() {
        assertThatThrownBy { board.recordRaceResult(CarName("dfs"), Round(2), 2) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Board.Error.InvalidName.message)
    }

    @Test
    fun addScore() {
        val currentRound = Round(1)
        val currentScore = 1
        board.recordRaceResult(car1, currentRound, currentScore)
        val (_, score) = board.getScoresByRound(currentRound).first { (name, _) -> name == car1 }
        assertThat(score).isEqualTo(currentScore)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 5, -1])
    fun getResultByAttempt_Invalid(currentRound: Round) {
        assertThatThrownBy { board.getScoresByRound(currentRound) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Board.Error.InvalidRound.message)
    }

    companion object {
        private const val CAR_NAME1 = "car1"
        private const val CAR_NAME2 = "car1"
    }
}