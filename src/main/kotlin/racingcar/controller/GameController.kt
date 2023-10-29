package racingcar.controller

import racingcar.domain.CarStatusUpdater
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
        val carStatusUpdater = CarStatusUpdater()

        val carStatus = carNames.associateWith { "" }.toMutableMap()
        var currentCount = 0
        while (currentCount < attemptCount) {
            for (car in carStatus) {
                carStatusUpdater.moveCarForward(carStatus, car.key)
            }

            currentCount++
        }
    }

    private fun printResult() {

    }
}
