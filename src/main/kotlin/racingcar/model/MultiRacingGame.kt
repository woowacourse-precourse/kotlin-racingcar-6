package racingcar.model

import racingcar.utils.RandomUtils
import racingcar.views.InputView
import racingcar.views.OutputView

class MultiRacingGame(
    private val inputView: InputView,
    private val randomUtils: RandomUtils,
    private val validateRacingCount: ValidateRacingCount,
    private val outputView: OutputView,
) {

    companion object {
        const val DEFAULT_SCORE = 0
        const val INCREMENT_SCORE = 1
        const val ADVANCE_MINIMUM = 4
    }

    fun inputTryCount(multiCarName: List<String?>) {
        inputView.inputTryCountMessage()
        val tryCount = inputView.inputView()
        val validateTryCount = validateRacingCount.validateTryCount(tryCount)
        multiRacingGame(validateTryCount, multiCarName)
    }

    private fun multiRacingGame(tryCount: Int, multiCarName: List<String?>) {
        outputView.printResultMessage()
        repeatRacing(tryCount, multiCarName)
    }

    private val scoreMap = mutableMapOf<String, Int>()

    private fun repeatRacing(tryCount: Int, multiCarName: List<String?>) {
        repeat(tryCount) {
            racingEachCar(multiCarName)
            outputView.printMultiGameResult(multiCarName, scoreMap)
        }
        multiRacingWinner()
    }

    private fun racingEachCar(multiCarName: List<String?>) {
        for (carName in multiCarName) {
            racingSingleCar(carName)
        }
    }

    private fun racingSingleCar(carName: String?) {
        val randomNum = randomUtils.getRandom()
        if (checkPositiveForward(randomNum)) {
            scoreMap[carName!!] = scoreMap.getOrDefault(carName, DEFAULT_SCORE) + INCREMENT_SCORE
        }
    }

    private fun multiRacingWinner() {
        val highestScore = scoreMap.values.maxOrNull() ?: 0
        noMultiRacingWinner(highestScore)
        val winners = scoreMap.filter { it.value == highestScore }.keys
        outputView.printMultiWinner(winners)
    }

    private fun noMultiRacingWinner(highestScore: Int) {
        if (highestScore == DEFAULT_SCORE) {
            outputView.printNoWinner()
        }
    }

    private fun checkPositiveForward(randomNum: Int): Boolean {
        return randomNum >= ADVANCE_MINIMUM
    }
}
