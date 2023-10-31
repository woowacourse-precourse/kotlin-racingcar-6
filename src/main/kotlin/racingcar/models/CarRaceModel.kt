package racingcar.models

import camp.nextstep.edu.missionutils.Randoms

class CarRaceModel {
    private val carNameAndScore = mutableMapOf<String, Int>()

    fun initializeScores(carNames: List<String>) {
        for (carName in carNames) {
            carNameAndScore[carName] = 0
        }
    }

    fun updateScores(carNames: List<String>) {
        for (carName in carNames) {
            if (carNameAndScore.containsKey(carName) && Randoms.pickNumberInRange(0, 9) >= 4) {
                carNameAndScore[carName] = carNameAndScore[carName]!! + 1
            }
        }
    }

    fun splitWinners(): String {
        return getScores().filter { it.value == carNameAndScore.values.maxOrNull() }.keys.joinToString(", ")
    }

    fun splitCarNames(readLine: String): List<String> {
        return readLine.split(",")
    }

    fun generateResults(): String {
        val allResult = getScores().map { (carName, score) ->
            val scoreResult = "-".repeat(score)
            "$carName : $scoreResult"
        }

        return allResult.joinToString("\n")
    }

    fun getScores(): Map<String, Int> {
        return carNameAndScore
    }

    fun setTestCodeDummy(pobiScore: Int, woniScore: Int, tobiScore: Int) {
        carNameAndScore["pobi"] = pobiScore
        carNameAndScore["woni"] = woniScore
        carNameAndScore["tobi"] = tobiScore
    }
}