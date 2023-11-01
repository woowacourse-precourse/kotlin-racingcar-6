package racingcar.Round

import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.model.Round

class Round {
    @Test
    fun `1부터 1000사이의 수로 Round 객체가 생성되면 예외가 발생하지 않는다`() {
        val round = Randoms.pickNumberInRange(1, 1000)

        assertDoesNotThrow { Round(round) }
    }

    @Test
    fun `0 이하의 수로 Round 객체가 생성되면 예외가 발생한다`() {
        val negativeRound = -1

        assertThrows<IllegalArgumentException> { Round(negativeRound) }
    }

    @Test
    fun `1000 초과의 수로 Round 객체가 생성되면 예외가 발생한다`() {
        val overRound = -1

        assertThrows<IllegalArgumentException> { Round(overRound) }
    }

}