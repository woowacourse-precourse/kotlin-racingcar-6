package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ScoresTest {

    private val scores = Scores.from(lastRound = Round(3))

    @Test
    @DisplayName("attempt 값이 최대를 넘었을 때, 에러를 발생하는지")
    fun addCurrentScore_overflowAttempt() {
        assertThatThrownBy { scores.addCurrentScore(round = Round(4), score = 4) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Scores.Error.OverflowRound.message)
    }

    @Test
    @DisplayName("해당 주차의 점수가 잘 기록되는지 확인")
    fun addCurrentScore() {
        val round1 = Round(1)
        val round3 = Round(3)
        scores.addCurrentScore(round3, 4)
        scores.addCurrentScore(round1, 3)
        assertThat(scores.scoreByRound[round3]).isEqualTo(4)
        assertThat(scores.scoreByRound[round1]).isEqualTo(3)
    }
}