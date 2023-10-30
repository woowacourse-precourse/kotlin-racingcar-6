package racingcar.model

import racingcar.controller.inputView
import racingcar.controller.randomUtils
import racingcar.controller.validateRacingCount
import racingcar.views.OutputView

class MultiRacingGame() {

    private val outputView = OutputView()

    fun inputTryCount(multiCarName: List<String?>) {
        inputView.inputTryCountMessage()
        val tryCount = inputView.inputView()
        validateRacingCount.validateTryCount(tryCount, multiCarName)
    }

    fun multiRacingGame(tryCount: Int, multiCarName: List<String?>) {
        outputView.printResultMessage()
        repeatRacing(tryCount, multiCarName)
    }

    private val scoreMap = mutableMapOf<String, Int>()

    private fun repeatRacing(tryCount: Int, multiCarName: List<String?>) {
        repeat(tryCount) {
            racingEachCar(multiCarName)
            outputView.printMultiGameResult(multiCarName, scoreMap)
        }
        multiChampion()
    }

    private fun racingEachCar(multiCarName: List<String?>) {
        for (carName in multiCarName) {
            racingSingleCar(carName)
        }
    }

    private fun racingSingleCar(carName: String?) {
        val randomNum = randomUtils.getRandom()
        if (checkPositiveForward(randomNum)) {
            scoreMap[carName!!] = scoreMap.getOrDefault(carName, 0) + 1
        }
    }

    private fun multiChampion() {
        val highestScore = scoreMap.values.maxOrNull() ?: 0
        val winners = scoreMap.filter { it.value == highestScore && it.key != null }.keys
        outputView.printMultiWinner(winners)
    }

    private fun checkPositiveForward(randomNum: Int): Boolean {
        return randomNum >= 4
    }
}
