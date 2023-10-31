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

}