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
        val racingCarNameList = "pobi,pobibic".split(",")

        assertThrows<IllegalArgumentException> { inputView.validateRacingCarName(racingCarNameList) }
    }


    @Test
    fun `자동차 이름 중복 예외 처리`() {
        val racingCarNameList = "pobi,pobi".split(",")

        assertThrows<IllegalArgumentException> { inputView.validateRacingCarName(racingCarNameList) }
    }


    @Test
    fun `자동차 이름 쉼표(,) 뒤 빈값 예외 처리`() {
        val racingCarNameList = "pobi,woni,".split(",")

        assertThrows<IllegalArgumentException> { inputView.validateRacingCarName(racingCarNameList) }
    }
}