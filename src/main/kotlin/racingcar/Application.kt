package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


const val PROMPT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
const val PROMPT_ATTEMPTS = "시도할 횟수는 몇 회인가요?"
const val RESULT = "\n실행 결과"
const val WINNER_MESSAGE = "최종 우승자 : "

const val MAX_CAR_NAME_LENGTH = 5
const val START_IDX = 0
const val INITIAL_IDX = 0
const val END_IDX = 9
const val CONDITION = 4

data class Car(val name: String) {
    private var position: Int = INITIAL_IDX

    fun move() {
        if (Randoms.pickNumberInRange(START_IDX, END_IDX) >= CONDITION) {
            position++
        }
    }

    fun getPosition(): Int {
        return position
    }
}

fun main() {
    val carNames = readCarNames()
    val cars = createCars(carNames)

    val inputAttempts = readAttempts()
    println(RESULT)

    val maxPosition = simulateRace(cars, inputAttempts)
    val winners = findWinners(cars, maxPosition)
    println(WINNER_MESSAGE+winners)
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
        if (input <= START_IDX) throw IllegalArgumentException()
        input
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
}

private fun createCars(names: List<String>): List<Car> {
    return names.map { Car(it) }
}

private fun simulateRace(cars: List<Car>, attempts: Int): Int {
    var maxPosition = INITIAL_IDX

    repeat(attempts) {
        cars.forEach { it.move() }
        val max = cars.maxOfOrNull { it.getPosition() }
        if (max != null && max > maxPosition) {
            maxPosition = max
        }

        cars.forEach { println("${it.name} : ${"-".repeat(it.getPosition())}") }
        println()
    }
    return maxPosition
}

private fun findWinners(cars: List<Car>, maxPosition: Int): String {
    return cars.filter { it.getPosition() == maxPosition }.joinToString(", ") { it.name }
}
