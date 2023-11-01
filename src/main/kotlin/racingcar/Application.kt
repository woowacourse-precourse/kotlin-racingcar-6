package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class Car(val name: String) {
    var position = 0
}

fun main() {
    val carNames = inputCarNames()
    val numberOfAttempts = inputNumberOfAttempts()
    val cars = carNames.map { Car(it) }

    println("\n실행 결과")

    for (attempt in 1..numberOfAttempts) {
        val roundResults = simulateRace(cars)
        printRoundResults(roundResults)
    }

    val winners = determineWinners(cars)
    printWinners(winners)
}

fun inputCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = readLine() ?: ""
    val carNames = input.split(",").map { it.trim() }

    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.")
    }

    return carNames
}

fun inputNumberOfAttempts(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return readLine()?.toIntOrNull() ?: 0
}

fun simulateRace(cars: List<Car>): Map<String, Int> {
    val roundResults = mutableMapOf<String, Int>()

    for (car in cars) {
        val randomValue = Randoms.pickNumberInRange(0, 9)
        if (randomValue >= 4) {
            car.position++
        }
        roundResults[car.name] = car.position
    }

    return roundResults
}

fun printRoundResults(roundResults: Map<String, Int>) {
    roundResults.forEach { (carName, position) ->
        val carDisplay = "-".repeat(position)
        println("$carName : $carDisplay")
    }
    print("\n")
}

fun determineWinners(cars: List<Car>): List<String> {
    val maxPosition = cars.map { it.position }.maxOrNull()
    return cars.filter { it.position == maxPosition }.map { it.name }
}

fun printWinners(winners: List<String>) {
    val winnersString = winners.joinToString(", ")
    println("최종 우승자: $winnersString")
}
