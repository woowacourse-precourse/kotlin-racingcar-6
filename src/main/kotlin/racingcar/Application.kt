package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class RacingCar(val name: String) {
    var position = 0
}

fun main() {
    try {
        val carNames = getCarNames()
        val tryCount = getTryCount()
        println("")

        val cars = createCars(carNames)

        println("실행 결과")
        race(tryCount, cars)

        announceWinner(cars)

    } catch (e: IllegalArgumentException) {
        println("에러: ${e.message}")
    }
}

fun getCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = readLine()?.split(",")?.map { it.trim() } ?: throw IllegalArgumentException("잘못된 입력입니다.")
    if (input.any { !it.matches(Regex("[a-zA-Z]+")) || it.length !in 1..5 }) {
        throw IllegalArgumentException("자동차 이름은 알파벳 문자로 이루어져 있고, 1자 이상 5자 이하만 가능합니다.")
    }
    return input
}

fun getTryCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return Console.readLine()?.toInt() ?: throw IllegalArgumentException("잘못된 입력입니다.")
}

fun createCars(carNames: List<String>): List<RacingCar> {
    return carNames.map { RacingCar(it) }
}

fun race(tryCount: Int, cars: List<RacingCar>) {
    repeat(tryCount) {
        cars.forEach { car ->
            moveCar(car)
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }
}

fun moveCar(car: RacingCar) {
    val randomValue = Randoms.pickNumberInRange(0, 9)
    if (randomValue >= 4) {
        car.position++
    }
}

fun announceWinner(cars: List<RacingCar>) {
    val maxPosition = cars.maxOf { it.position }
    val winners = cars.filter { it.position == maxPosition }.joinToString(", ") { it.name }

    println("최종 우승자 : $winners")
}