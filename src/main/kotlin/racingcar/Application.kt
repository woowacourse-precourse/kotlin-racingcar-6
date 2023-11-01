package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object CarNameConstraints {
    const val VALID_MAXIMUM_LENGTH = 5
}

object CarMovementConstraints {
    const val RANDOM_NUMBER_GENERATOR_MINIMUM_VALUE = 0
    const val RANDOM_NUMBER_GENERATOR_MAXIMUM_VALUE = 9
    const val CAR_MOVEMENT_THRESHOLD = 4
    const val MOVEMENT_UNIT = 1
    const val NO_MOVEMENT = 0
}

object RacingCarGameMessages {
    const val RACECAR_NAME_QUERY = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    const val RACECAR_TURN_COUNT_QUERY = "시도할 횟수는 몇 회인가요?"
    const val GAME_RESULT_TITLE = "실행 결과"
    const val FINAL_WINNER_PREFIX = "최종 우승자 : "
}

class RaceCar(val name: String, var position: Int = 0) {
    init {
        require((name.length <= CarNameConstraints.VALID_MAXIMUM_LENGTH)) { "Invalid Car Name." }
    }

    override fun toString(): String {
        return "$name : ${"-".repeat(position)}"
    }

}

fun filterMovableNumber(target: Int): Int {
    if (target < CarMovementConstraints.CAR_MOVEMENT_THRESHOLD) {
        return CarMovementConstraints.NO_MOVEMENT
    }
    return CarMovementConstraints.MOVEMENT_UNIT
}

fun randomNumberGenerator(): Int {
    return Randoms.pickNumberInRange(
        CarMovementConstraints.RANDOM_NUMBER_GENERATOR_MINIMUM_VALUE,
        CarMovementConstraints.RANDOM_NUMBER_GENERATOR_MAXIMUM_VALUE
    )
}

fun moveDistance(): Int {
    val randomNumber = randomNumberGenerator()
    return filterMovableNumber(randomNumber)
}

private fun RaceCar.move() {
    position += moveDistance()
}

fun parseCarName(): List<RaceCar> {
    println(RacingCarGameMessages.RACECAR_NAME_QUERY)
    return Console.readLine().split(",").map { RaceCar(it.trim()) }
}

fun isNonnegativeInt(target: String): Boolean {
    return (target.isNotEmpty()) and (target.all { it.isDigit() })
}

fun parseTurnCount(): Int {
    println(RacingCarGameMessages.RACECAR_TURN_COUNT_QUERY)
    val turnCountString = Console.readLine()
    require(isNonnegativeInt(turnCountString)) { "Invalid Turn Count." }
    return turnCountString.toInt()
}

fun turnProcess(raceCars: List<RaceCar>) {
    for (raceCar in raceCars) {
        raceCar.move()
    }
}

fun decideWinners(raceCars: List<RaceCar>): List<String> {
    val longestDistance = raceCars.maxOfOrNull { it.position } ?: 0
    return raceCars.filter { it.position == longestDistance }.map { it.name }
}

fun main() {
    val raceCars = parseCarName()
    val turnCount = parseTurnCount()
    println("\n" + RacingCarGameMessages.GAME_RESULT_TITLE)
    for (i in 1..turnCount) {
        turnProcess(raceCars)
        println(raceCars.joinToString("\n", postfix = "\n"))
    }
    val winners = decideWinners(raceCars)
    println(winners.joinToString(", ", RacingCarGameMessages.FINAL_WINNER_PREFIX))
}
