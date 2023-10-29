package racingcar

import camp.nextstep.edu.missionutils.Randoms

// 자동차 경주
fun raceCars(carNames: List<String>): Map<String, String> {
    val carNamesAndResults = mutableMapOf<String, String>()
    val time = getRaceTime()

    for (i in carNames) {
        carNamesAndResults[i] = "" // 전진 값 초기화
    }

    for (i in 0 until time) {
        for (j in carNames) {
            val num = Randoms.pickNumberInRange(0, 9)
            if (num >= 4) {
                carNamesAndResults[j] += "-" // 4 이상의 수가 나오면 전진
            }
            println("$j : ${carNamesAndResults[j]}")
        }
        println()
    }

    return carNamesAndResults
}