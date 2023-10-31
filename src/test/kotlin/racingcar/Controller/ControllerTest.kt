package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.RacingCar
import racingcar.view.InputView
import racingcar.view.OutputView

class ControllerTest {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val controller = Controller(inputView, outputView)

    @Test
    fun `입력받은 자동차의 이름 수만큼 RacingCar 객체 생성`() {
        val carNames = listOf("jon", "pobi", "dana")
        assertThat(controller.makeRacingCars(carNames))
            .isEqualTo(
                listOf(
                    RacingCar("jon", 0),
                    RacingCar("pobi", 0),
                    RacingCar("dana", 0)
                )
            )
    }

    @Test
    fun `자동차 목록 중 우승자의 forward 값 확인하기`() {
        val racingCars = listOf(
            RacingCar("jon", 2),
            RacingCar("pobi", 3),
            RacingCar("dana", 1)
        )
        assertThat(controller.getWinnerForward(racingCars)).isEqualTo(3)
    }

    @Test
    fun `최종 우승자의 목록 탐색`() {
        val racingCars = listOf(
            RacingCar("jon", 2),
            RacingCar("pobi", 3),
            RacingCar("dana", 3)
        )
        assertThat(controller.getWinnerCars(racingCars))
            .isEqualTo(listOf("pobi", "dana"))
    }
}