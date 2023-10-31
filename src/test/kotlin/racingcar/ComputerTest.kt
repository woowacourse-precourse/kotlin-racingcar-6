package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ComputerTest {
    private val computer = Computer()
    private val cars = arrayListOf<Car>()

    @Test
    fun `최종 우승자 출력테스트`() {
        cars.run {
            add(Car("qwer", WINNER_POSITION))
            add(Car("asdf", POSITION))
            add(Car("zxcv", POSITION))
        }
        val winnerStatus = computer.getWinnerStatus(cars)
        assertThat(winnerStatus).isEqualTo("최종 우승자 : qwer")
    }

    @Test
    fun `최종 우승자 필터링 테스트`() {
        cars.run {
            add(Car("qwer", WINNER_POSITION))
            add(Car("asdf", POSITION))
            add(Car("zxcv", POSITION))
        }
        val winners = computer.getWinner(cars, WINNER_POSITION)
        var winner = ""
        winners.forEach {
            winner += it.name
        }
        assertThat(winner).isEqualTo("qwer")
    }

    @Test
    fun `최종 우승자 횟수 테스트`() {
        cars.run {
            add(Car("qwer", WINNER_POSITION))
            add(Car("asdf", POSITION))
            add(Car("zxcv", POSITION))
        }
        val winnerPosition = computer.getWinnerPosition(cars)

        assertThat(winnerPosition).isEqualTo(WINNER_POSITION)
    }

    companion object {
        const val WINNER_POSITION = 3
        const val POSITION = 2
    }
}