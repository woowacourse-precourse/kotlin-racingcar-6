package result

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import racingcar.car.Car
import racingcar.result.Winner

class ResultTest {

    @Test
    fun `최고 점수를 가진 사람이 한 명일 때 단독 우승자가 있음을 확인한다`() {
        val cars = listOf(Car("james", 1), Car("lea", 2), Car("kite", 5))
        val expectedWinner = Winner(cars).getWinners()
        val actualWinner = listOf("kite")
        assertThat(actualWinner).isEqualTo(expectedWinner)
    }

    @Test
    fun `최고 점수를 가진 사람이 중복될 때 공동 우승자가 있음을 확인한다`() {
        val cars = listOf(Car("james", 10), Car("lea", 10), Car("kite", 3))
        val expectedWinner = Winner(cars).getWinners()
        val actualWinners = listOf("james", "lea")
        assertThat(actualWinners).isEqualTo(expectedWinner)
    }
}

