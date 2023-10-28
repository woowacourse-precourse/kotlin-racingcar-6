package racingcar.controller

import racingcar.view.InputView

class GameController {

    fun run() {
        getUserInput()
        play()
        printResult()
    }

    private fun getUserInput(): Pair<ArrayList<String>, String> {
        val input = InputView()
        return Pair(input.getCarName(), input.getNumberOfAttemps())
    }

    private fun isValidInput() {

    }

    private fun play() {

    }

    private fun printResult() {

    }
}
