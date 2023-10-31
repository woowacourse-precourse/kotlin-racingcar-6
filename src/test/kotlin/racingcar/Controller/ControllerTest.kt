package racingcar.Controller

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


}