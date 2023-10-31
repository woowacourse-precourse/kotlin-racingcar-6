package racingcar

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms

private val racingCar = mutableMapOf<String, Int>() // 자동차 이름, 점수
private var tryCount: Int = 0

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    inputRacingCarName()

    println("시도할 횟수는 몇 회인가요?")
    inputTryCount()

}

private fun inputRacingCarName() {
    val readLine = readLine()
    val racingCarNameList = readLine.split(",")
    racingCarNameList.forEach { car ->
        if (car.length <= 5) {
            throw IllegalArgumentException()
        }

        racingCar[car] = 0
    }
}

private fun inputTryCount() {
    try {
        val readLine = readLine()
        tryCount = readLine.toInt()
    } catch (e: Exception) {
        throw IllegalArgumentException()
    }
}
