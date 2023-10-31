package racingcar

import camp.nextstep.edu.missionutils.Randoms

class CarRaceLogic {
    private lateinit var carNamesAndResults: MutableMap<String, String>
    private lateinit var carNamesAndInitalizedResults: MutableMap<String, String>
    private var time: Int = 0 // 시도 횟수
    private var randomNum: Int = 0 // 랜덤 숫자

    fun raceCars(carNames: List<String>): Map<String, String> {
        carNamesAndResults = initializeCarResults(carNames)
        time = RaceTime().getRaceTime()

        println(MessageConstants.RESULTS_TITLE)
        for (i in 0 until time) {
            raceRound(carNames, carNamesAndResults)
        }

        return carNamesAndResults
    }

    private fun initializeCarResults(carNames: List<String>): MutableMap<String, String> {
        carNamesAndInitalizedResults = mutableMapOf<String, String>()

        for (carName in carNames) {
            carNamesAndInitalizedResults[carName] = ""
        }

        return carNamesAndInitalizedResults
    }

    private fun raceRound(carNames: List<String>, carNamesAndResults: MutableMap<String, String>) {
        for (carName in carNames) {
            randomNum = Randoms.pickNumberInRange(0, 9)
            if (randomNum >= 4) {
                carNamesAndResults[carName] += "-"
            }
            println("$carName : ${carNamesAndResults[carName]}")
        }

        println()
    }
}