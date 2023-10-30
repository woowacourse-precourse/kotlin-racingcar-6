package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.controller.RacingCarController
import racingcar.view.InputView
import racingcar.view.OutputView


class RacingCarTest {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val racingCarController = RacingCarController(inputView, outputView)

    @Test
    fun `자동차 이름 5자 초과 예외 처리`() {
        val racingCarNameList = listOf("pobi", "pobibic")

        assertThrows<IllegalArgumentException> { inputView.validateRacingCarName(racingCarNameList) }
    }
}