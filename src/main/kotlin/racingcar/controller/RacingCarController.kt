package racingcar.controller

import racingcar.model.CarModel
import racingcar.view.InputView
import camp.nextstep.edu.missionutils.Console


class RacingCarController {
    private val model = CarModel()
    private val view = InputView()

    fun startRacingCarGame() {
        view.inputCarNames()
        val input = Console.readLine()
        val carNames = input.split(",")
        model.setCarNames(carNames)
    }
}