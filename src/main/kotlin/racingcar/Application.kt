package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val racingCarNames = splitRacingCarName(Console.readLine())
    invalidRacingCarNamesCheck(racingCarNames)
    println("시도할 횟수는 몇 회인가요?")
    val tryCount = Console.readLine().toIntOrNull()
    invalidTryCountCheck(tryCount)
    val racingCars = racingCarNames.map { RacingCar(it) }
    race(racingCars, tryCount)
    print(finalWinner(racingCars))
}

fun finalWinner(racingCars: List<RacingCar>): String {
    val winner = racingCars.maxBy { it.mileage }
    val winnerNames = racingCars.filter { it.mileage == winner.mileage }.map { it.name }
    return "최종 우승자 : ${winnerNames.joinToString(", ")}"
}

fun race(racingCars: List<RacingCar>, tryCount: Int?) {
    println("\n실행 결과")
    repeat(tryCount!!) {
        racingCars.forEach {
            it.move()
            println(it.nameAndMileage())
        }
        println()
    }
}

fun invalidTryCountCheck(tryCount: Int?) {
    when {
        tryCount == null -> throw IllegalArgumentException("정수를 입력하세요.")
        tryCount < 1 -> throw IllegalArgumentException("1 이상의 숫자를 입력하세요.")
    }
}

fun invalidRacingCarNamesCheck(racingCars: List<String>) {
    racingCars.forEach {
        if (it.length > 5)
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
    }
}

fun splitRacingCarName(readLine: String): List<String> {
    return readLine.split(",")
}
