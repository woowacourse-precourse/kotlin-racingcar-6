package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RefereeTest {
    @Test
    fun `자동차의 위치를 비교하여 우승자 이름 반환 테스트`() {
        val carList = listOf(
            Car("pobi", 3),
            Car("woni", 0),
            Car("jun", 2)
        )
        val referee = Referee(carList)
        val result = referee.getWinningCarNames()
        assertThat(result).containsExactly("pobi")
    }

    @Test
    fun `자동차의 위치를 비교하여 우승자 이름 반환 테스트 2`() {
        val carList = listOf(
            Car("pobi", 2),
            Car("woni", 2),
            Car("jun", 0)
        )
        val referee = Referee(carList)
        val result = referee.getWinningCarNames()
        assertThat(result).containsExactly("pobi", "woni")
    }
}