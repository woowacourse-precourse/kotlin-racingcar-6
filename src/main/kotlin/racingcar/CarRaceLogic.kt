package racingcar

import camp.nextstep.edu.missionutils.Randoms

class CarRaceLogic {
    private lateinit var carNamesAndResults: MutableMap<String, String>
    private lateinit var carNamesAndInitalizedResults: MutableMap<String, String>
    private var time: Int = 0
    private var num: Int = 0

    // 자동차 경주
    fun raceCars(carNames: List<String>): Map<String, String> {
        carNamesAndResults = initializeCarResults(carNames)
        time = RaceTime().getRaceTime()

        println("\n실행 결과")
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
            num = Randoms.pickNumberInRange(0, 9)
            if (num >= 4) {
                carNamesAndResults[carName] += "-"
            }
            println("$carName : ${carNamesAndResults[carName]}")
        }

        println()
    }
}