package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val PROMPT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
const val PROMPT_ATTEMPTS = "시도할 횟수는 몇 회인가요?"
const val RESULT = "\n실행 결과"
const val WINNER_MESSAGE = "최종 우승자 : "

const val MAX_CAR_NAME_LENGTH = 5
const val START_IDX = 0
const val END_IDX = 9
const val CONDITION = 4

data class Car(val name: String) {
    var position: Int = 0

    fun move() {
        if (Randoms.pickNumberInRange(START_IDX, END_IDX) >= CONDITION) {
            position++
        }
    }

    fun display(): String = "$name : ${"-".repeat(position)}"
}

fun main() {
    val carNames = readCarNames()
    val cars = carNames.map { Car(it) }

    val attempts = readAttempts()
    println(RESULT)

    val maxPosition = simulateRace(cars, attempts)

    val winners = cars.filter { it.position == maxPosition }.joinToString(", ") { it.name }
    println("$WINNER_MESSAGE$winners")
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

private fun simulateRace(cars: List<Car>, attempts: Int): Int {
    repeat(attempts) {
        cars.forEach { it.move() }
        cars.forEach { println(it.display()) }
        println()
    }
    return cars.map { it.position }.maxOrNull() ?: 0
}
