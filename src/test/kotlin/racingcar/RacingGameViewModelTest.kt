package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.util.Constants
import racingcar.util.RandomNumberGenerator


class RacingGameViewModelTest {
    @Test
    fun `savePlayer() 이름이 다섯자를 초과하면 예외`() {
        val viewModel = RacingGameViewModel(RandomNumberGenerator())
        val exception = assertThrows<IllegalArgumentException> {
            viewModel.savePlayers("kim,park,taejune", ',')
        }
        assertEquals(Constants.EXCEPTION_PLAYER_NAME_LENGTH, exception.message)
    }

    @Test
    fun `savePlayer() 이름이 다섯자 이하라면 데이터 저장 성공`() {
        val viewModel = RacingGameViewModel(RandomNumberGenerator())
        viewModel.savePlayers("kim,park,jun", ',')

        assertThat(viewModel.playerList).hasSize(3)
        assertThat(viewModel.playerList).extracting("name").contains("kim", "park", "jun")
    }

    @Test
    fun `saveRound() 숫자가 아닌 입력은 예외`() {
        val viewModel = RacingGameViewModel(RandomNumberGenerator())
        val exception = assertThrows<IllegalArgumentException> {
            viewModel.saveRound("a")
        }
        assertEquals(Constants.EXCEPTION_ROUND_NOT_NUMBER, exception.message)
    }

    @Test
    fun `saveRound() 0 이하의 음수 입력은 예외`() {
        val viewModel = RacingGameViewModel(RandomNumberGenerator())
        val exception = assertThrows<IllegalArgumentException> {
            viewModel.saveRound("-5")
        }
        assertEquals(Constants.EXCEPTION_ROUND_NOT_POSITIVE, exception.message)
    }

    @Test
    fun `saveRound() 입력 저장 성공`() {
        val viewModel = RacingGameViewModel(RandomNumberGenerator())
        viewModel.saveRound("5")
        assertEquals(5, viewModel.round)
    }
}