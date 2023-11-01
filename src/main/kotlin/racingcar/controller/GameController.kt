package racingcar.controller

import racingcar.constant.Constants.EXECUTION_RESULT_STRING
import racingcar.domain.CarStatusUpdater
import racingcar.domain.NumberGenerator
import racingcar.util.Validator
import racingcar.view.InputView
import racingcar.view.RaceView
import racingcar.view.ResultView

class GameController {

    private val carStatus = mutableMapOf<String, String>()

    fun run() {
        val (carNames, attemptCount) = getUserInput()
        println()
        Validator(carNames, attemptCount)
        play(carNames, attemptCount.toInt())
        printResult()
    }

    private fun getUserInput(): Pair<ArrayList<String>, String> {
        val input = InputView()
        return Pair(input.getCarName(), input.getNumberOfAttemps())
    }

    private fun play(carNames: ArrayList<String>, attemptCount: Int) {
        println(EXECUTION_RESULT_STRING)

        val carStatusUpdater = CarStatusUpdater()
        val numberGenerator = NumberGenerator()
        val raceView = RaceView()

        carStatus.clear()
        carStatus.putAll(carNames.associateWith { "" })
        var currentCount = 0
        var randomNumber: Int
        while (currentCount < attemptCount) {
            for (car in carStatus) {
                randomNumber = numberGenerator.createRandomNumber()
                carStatusUpdater.moveCarForward(carStatus, car.key, randomNumber)
            }
            raceView.printCarProgress(carStatus)

            currentCount++
        }
    }

    private fun printResult() {
        val resultView = ResultView()
        resultView.printWinner(carStatus)
    }
}
