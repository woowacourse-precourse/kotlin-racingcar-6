package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.RacingCar

class OutputViewTest {
    private val outputView = OutputView()

    @Test
    fun `각 차수별 실행 결과 출력`() {
        val racingCars = listOf(
            RacingCar("pobi", 2),
            RacingCar("woni", 4),
            RacingCar("jun", 3)
        )
        assertThat(outputView.printResult(racingCars))
            .isEqualTo("pobi : --\n" +
                    "woni : ----\n" +
                    "jun : ---\n")
    }

    @Test
    fun `최종 우승자가 단독인 경우 `() {
        val winnerCars = listOf("pobi")
        val result = outputView.printWinner(winnerCars)
        assertThat(result).isEqualTo("pobi")
    }

    @Test
    fun `최종 우승자가 공동인 경우`() {
        val winnerCars = listOf("pobi","jon")
        val result = outputView.printWinner(winnerCars)
        assertThat(result).isEqualTo("pobi, jon")
    }

}