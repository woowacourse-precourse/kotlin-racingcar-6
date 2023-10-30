package racingcar.model

import racingcar.checkPositiveForward
import racingcar.outputView
import racingcar.randomUtils

class MultiRacingGame {
    fun multiRacingGame(tryCount: Int, multiCarName: List<String?>) {
        outputView.printResultMessage()
        repeatRacing(tryCount, multiCarName)
    }

    val scoreMap = mutableMapOf<String, Int>()

    private fun repeatRacing(tryCount: Int, multiCarName: List<String?>) {
        repeat(tryCount) {
            racingEachCar(multiCarName)
            outputView.printMultiGameResult(multiCarName)
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
        val highestScore = racingcar.multiRacingGame.scoreMap.values.maxOrNull() ?: 0
        val winners = racingcar.multiRacingGame.scoreMap.filter { it.value == highestScore && it.key != null }.keys
        outputView.printMultiWinner(winners)
    }
}
