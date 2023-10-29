package racingcar.controller

import racingcar.domain.Judgment
import racingcar.domain.NumberGenerator
import racingcar.util.Validator
import racingcar.view.InputView

class GameController {

    fun run() {
        val (carNames, attemptCount) = getUserInput()
        Validator(carNames, attemptCount)
        play(carNames, attemptCount.toInt())
        printResult()
    }

    private fun getUserInput(): Pair<ArrayList<String>, String> {
        val input = InputView()
        return Pair(input.getCarName(), input.getNumberOfAttemps())
    }

    private fun play(carNames: ArrayList<String>, attemptCount: Int) {
        val numberGenerator = NumberGenerator()
        val judgment = Judgment()

        var currentCount = 0
        while (currentCount < attemptCount) {
                val randomNumber = numberGenerator.createRandomNumber()
                if(judgment.canMoveForward(randomNumber)) { }

            currentCount++
        }
    }

    private fun printResult() {

    }
}
