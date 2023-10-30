package racingcar.controllers

import camp.nextstep.edu.missionutils.Console
import racingcar.models.CarRaceModel
import racingcar.views.CarRaceView

class CarRaceController {
    private val model = CarRaceModel()
    private val view = CarRaceView()

    fun startRace() {
        val carNames = inputCarNames()
        val numberOfAttempts = inputNumberOfAttempts()
        model.initializeScores(carNames)

        view.printSentenceResult()
        for (i in 1..numberOfAttempts) {
            model.updateScores(carNames)
            view.showResults(model.getScores())
        }

        view.showWinners(model.getScores())
    }

    private fun inputCarNames(): List<String> {
        view.printSentenceWriteCarName()
        val carNames = Console.readLine().split(",")
        val validNames = carNames.filter { it.length <= 5 }

        if (validNames.size != carNames.size) {
            throw IllegalArgumentException("5자 이하로 입력해주세요")
        }

        return validNames
    }

    private fun inputNumberOfAttempts(): Int {
        view.printSentenceWordWriteAttempts()
        return Console.readLine().toInt()
    }
}