package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val racingCars = splitRacingCarName(Console.readLine())
    invalidRacingCarsCheck(racingCars)
}

fun invalidRacingCarsCheck(racingCars: List<String>) {
    racingCars.forEach {
        if (it.length > 5)
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
    }
}

fun splitRacingCarName(readLine: String): List<String> {
    return readLine.split(",")
}
