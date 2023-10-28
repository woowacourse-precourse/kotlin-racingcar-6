package racingcar.controller

import racingcar.view.InputView

class GameController {

    fun run() {
        getUserInput()
        play()
        printResult()
    }

    private fun getUserInput() {
        val input = InputView()
        val carNames = input.getCarName()
    }

    private fun play() {

    }

    private fun printResult() {

    }
}
