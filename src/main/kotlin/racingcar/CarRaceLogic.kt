package racingcar

import camp.nextstep.edu.missionutils.Randoms

// 자동차 경주
fun raceCars(carNames: List<String>): Map<String, String> {
    val carNamesAndResults = initializeCarResults(carNames)
    val time = getRaceTime()

    for (i in 0 until time) {
        raceRound(carNames, carNamesAndResults)
    }

    return carNamesAndResults
}

private fun initializeCarResults(carNames: List<String>): MutableMap<String, String> {
    val carNamesAndResults = mutableMapOf<String, String>()

    for (carName in carNames) {
        carNamesAndResults[carName] = ""
    }

    return carNamesAndResults
}

private fun raceRound(carNames: List<String>, carNamesAndResults: MutableMap<String, String>) {
    for (carName in carNames) {
        val num = Randoms.pickNumberInRange(0, 9)
        if (num >= 4) {
            carNamesAndResults[carName] += "-"
        }
        println("$carName : ${carNamesAndResults[carName]}")
    }

    println()
}