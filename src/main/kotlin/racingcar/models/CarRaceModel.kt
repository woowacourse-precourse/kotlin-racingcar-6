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

    fun getScores(): Map<String, Int> {
        return carNameAndScore
    }
}