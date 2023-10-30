package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val PROMPT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
const val PROMPT_ATTEMPTS = "시도할 횟수는 몇 회인가요?"
const val MAX_CAR_NAME_LENGTH = 5

data class Car(val name: String) {
    var position: Int = 0

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }

    fun display(): String {
        return "$name : ${"-".repeat(position)}"
    }
}

fun main() {
    val carNames = readCarNames()
    val cars = createCars(carNames)

    println("\n실행 결과")

    val inputAttempts = readAttempts()
    val maxPosition = simulateRace(cars, inputAttempts)
    val winners = findWinners(cars, maxPosition)

    println("최종 우승자 : $winners")
}

private fun readCarNames(): List<String> {
    println(PROMPT_CAR_NAMES)

    val inputNames = Console.readLine()

    if (inputNames.split(",").any { it.length > MAX_CAR_NAME_LENGTH }) {
        throw IllegalArgumentException()
    }
    return inputNames.split(",")
}

private fun readAttempts(): Int {
    println(PROMPT_ATTEMPTS)

    return try {
        val input = Console.readLine().toInt()
        if (input <= 0) throw IllegalArgumentException()
        input
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
}

private fun createCars(names: List<String>): List<Car> {
    return names.map { Car(it) }
}

private fun simulateRace(cars: List<Car>, attempts: Int): Int {
    var maxPosition = 0

    repeat(attempts) {
        cars.forEach { it.move() }

        val max = cars.map { it.position }.maxOrNull()

        if (max != null && max > maxPosition) {
            maxPosition = max
        }

        cars.forEach { println(it.display()) }
        println()
    }
    return maxPosition
}

private fun findWinners(cars: List<Car>, maxPosition: Int): String {
    return cars.filter { it.position == maxPosition }.joinToString(", ") { it.name }
}
