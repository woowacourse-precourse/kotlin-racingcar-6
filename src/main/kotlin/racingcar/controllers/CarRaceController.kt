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
            view.showResults(generateResults(model.getScores()))
        }

        view.showWinners(model.getScores())
    }

    private fun inputCarNames(): List<String> {
        view.printSentenceWriteCarName()
        val carNames = splitCarNames(Console.readLine())
        val validNames = carNames.filter { it.length <= 5 }

        when {
            validNames.size != carNames.size -> throw IllegalArgumentException("5자 이하로 입력해주세요.")
            carNames.any { it.isBlank() } -> throw IllegalArgumentException("공백입력 불가합니다")
            carNames.size < 2 -> throw IllegalArgumentException("1명이상 입력해주세요")
            carNames.toSet().size != carNames.size -> throw IllegalArgumentException("중복된 이름은 불가합니다")
            else -> return validNames
        }
    }

    fun splitCarNames(readLine: String): List<String> {
        return readLine.split(",")
    }

    fun generateResults(carNameAndScore: Map<String, Int>): List<String> {
        val allResult = carNameAndScore.map { (carName, score) ->
            val scoreResult = "-".repeat(score)
            "$carName : $scoreResult"
        }

        return allResult
    }

    private fun inputNumberOfAttempts(): Int {
        view.printSentenceWordWriteAttempts()
        val attempt = Console.readLine()

        if (attempt.isEmpty() || attempt.isBlank() || attempt.toIntOrNull() == null || attempt.toInt() <= 0) {
            throw IllegalArgumentException("정수만 입력해주세요")
        }

        return attempt.toInt()
    }
}