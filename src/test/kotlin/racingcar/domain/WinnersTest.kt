package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class WinnersTest {
    @Test
    fun `우승자찾기_단독우승자임`() {
        val firstPlace = RacingCar("pobi", 1)
        val secondPlace = RacingCar("woni", 0)

        val winners = Winners(listOf(firstPlace, secondPlace))

        Assertions.assertThat(winners.toString()).isEqualTo("최종 우승자 : pobi")
    }

    @Test
    fun 우승자찾기_공동우승자임() {
        val firstPlace = RacingCar("pobi", 1)
        val sameFirstPlace = RacingCar("woni", 1)

        val winners = Winners(listOf(firstPlace, sameFirstPlace))

        Assertions.assertThat(winners.toString()).isEqualTo("최종 우승자 : pobi, woni")
    }
}