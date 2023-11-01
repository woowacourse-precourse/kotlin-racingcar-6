package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.util.Constants
import racingcar.util.RandomNumberGenerator


class RacingGameViewModelTest {
    @Test
    fun `savePlayer() 이름이 다섯자를 초과하면 예외`() {
        val viewModel = RacingGameViewModel(RandomNumberGenerator())
        assertThrows<IllegalArgumentException>(Constants.EXCEPTION_PLAYER_NAME_LENGTH) {
            viewModel.savePlayers("kim,park,taejune", ',')
        }
    }

    @Test
    fun `savePlayer() 이름이 다섯자 이하라면 데이터 저장 성공`() {
        val viewModel = RacingGameViewModel(RandomNumberGenerator())
        viewModel.savePlayers("kim,park,jun", ',')

        assertThat(viewModel.playerList).hasSize(3)
        assertThat(viewModel.playerList).extracting("name").contains("kim", "park", "jun")
    }


}