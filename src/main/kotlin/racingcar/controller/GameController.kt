package racingcar.controller

import racingcar.util.Validator
import racingcar.view.InputView

class GameController {

    fun run() {
        val (carNames, attemptCount) = getUserInput()
        Validator(carNames, attemptCount)
        play()
        printResult()
    }

    private fun getUserInput(): Pair<ArrayList<String>, String> {
        val input = InputView()
        return Pair(input.getCarName(), input.getNumberOfAttemps())
    }

    private fun play() {

    }

    private fun printResult() {

    }
}
