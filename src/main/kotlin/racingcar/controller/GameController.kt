package racingcar.controller

import racingcar.domain.NumberGenerator
import racingcar.util.Validator
import racingcar.view.InputView

class GameController {

    fun run() {
        val (carNames, attemptCount) = getUserInput()
        Validator(carNames, attemptCount)
        play(attemptCount.toInt())
        printResult()
    }

    private fun getUserInput(): Pair<ArrayList<String>, String> {
        val input = InputView()
        return Pair(input.getCarName(), input.getNumberOfAttemps())
    }

    private fun play(attemptCount: Int) {
        val numberGenerator = NumberGenerator()

        var currentCount = 0
        while (currentCount < attemptCount) {
            val randomNumber = numberGenerator.createRandomNumber()
            currentCount++
        }
    }

    private fun printResult() {

    }
}
