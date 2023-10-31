package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

private val racingCar = mutableMapOf<String, Int>() // 자동차 이름, 점수

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    inputRacingCarName()

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
