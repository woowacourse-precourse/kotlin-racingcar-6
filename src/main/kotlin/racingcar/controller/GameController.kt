package racingcar.controller

import racingcar.domain.CarStatusUpdater
import racingcar.util.Validator
import racingcar.view.InputView
import racingcar.view.RaceView

class GameController {

    fun run() {
        val (carNames, attemptCount) = getUserInput()
        println("")
        Validator(carNames, attemptCount)
        play(carNames, attemptCount.toInt())
        printResult()
    }

    private fun getUserInput(): Pair<ArrayList<String>, String> {
        val input = InputView()
        return Pair(input.getCarName(), input.getNumberOfAttemps())
    }

    private fun play(carNames: ArrayList<String>, attemptCount: Int) {
        println("실행 결과")
        val carStatusUpdater = CarStatusUpdater()
        val RaceView = RaceView()

        val carStatus = carNames.associateWith { "" }.toMutableMap()
        var currentCount = 0
        while (currentCount < attemptCount) {
            for (car in carStatus) {
                carStatusUpdater.moveCarForward(carStatus, car.key)
            }
            RaceView.printCarProgress(carStatus)

            currentCount++
        }
    }

    private fun printResult() {

    }
}
