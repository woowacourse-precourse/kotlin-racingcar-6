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

    println("실행 결과")
    repeat(tryCount) { _ ->
        racingCar.forEach { (carName, score) ->
            scoreUpdate(carName, score)
        }
        println()
    }

    finish()
}

private fun inputRacingCarName() {
    val readLine = readLine()
    val racingCarNameList = readLine.split(",")
    racingCarNameList.forEach { car ->
        if (car.length >= 5) {
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

private fun scoreUpdate(carName: String, score: Int) {
    val number = generateRandomNumber()

    if (canForward(number)) {
        racingCar[carName] = score + 1
    }
    progressBar(carName)
}

private fun generateRandomNumber(): Int {
    return Randoms.pickNumberInRange(0, 9)
}

private fun canForward(value: Int): Boolean {
    return value >= 4
}

private fun progressBar(carName: String) {
    val score = racingCar[carName] ?: 0
    println("$carName : ${"-".repeat(score)}")
}

private fun finish() {
    val maxScore = racingCar.maxOf { it.value }
    val maxScoreMap = racingCar.filterValues { it == maxScore }
    val winnerKeys = maxScoreMap.keys

    println("최종 우승자 : ${winnerKeys.joinToString(separator = ", ")}")
}