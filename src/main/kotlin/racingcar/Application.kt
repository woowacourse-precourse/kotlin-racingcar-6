package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object CarConstraints {
    const val NAME_MAXIMUM_LENGTH = 5
    const val RANDOM_MIN_VALUE = 0
    const val RANDOM_MAX_VALUE = 9
    const val MOVEMENT_THRESHOLD = 4
    const val MOVE_DISTANCE = 1
    const val NO_MOVE_DISTANCE = 0
}

object GameMessages {
    const val CAR_NAME_QUERY = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    const val TURN_COUNT_QUERY = "시도할 횟수는 몇 회인가요?"
    const val TURN_RESULTS = "실행 결과"
    const val FINAL_WINNER_PREFIX = "최종 우승자 : "
}

class RaceCar(val name: String, var position: Int = 0) {
    init {
        validateCarName(name)
    }

    private fun validateCarName(name: String) {
        require(name.length <= CarConstraints.NAME_MAXIMUM_LENGTH) { "Invalid Car Name." }
    }

    private fun shouldMove(): Boolean {
        val randomNumber = Randoms.pickNumberInRange(CarConstraints.RANDOM_MIN_VALUE, CarConstraints.RANDOM_MAX_VALUE)
        return randomNumber >= CarConstraints.MOVEMENT_THRESHOLD
    }

    private fun generateMoveDistance(): Int {
        return if (shouldMove()) CarConstraints.MOVE_DISTANCE else CarConstraints.NO_MOVE_DISTANCE
    }

    fun move() {
        position += generateMoveDistance()
    }

    override fun toString(): String {
        return "$name : ${"-".repeat(position)}"
    }

}

private fun promptCarNames(): List<RaceCar> {
    println(GameMessages.CAR_NAME_QUERY)
    return Console.readLine().split(",").map { RaceCar(it.trim()) }
}

private fun promptTurnCount(): Int {
    println(GameMessages.TURN_COUNT_QUERY)
    val turnCountString = Console.readLine()
    validateTurnCount(turnCountString)
    return convertTurnCount(turnCountString)
}

private fun validateTurnCount(turnCountString: String) {
    require((turnCountString.isNotEmpty()) and (turnCountString.all { it.isDigit() })) { "Invalid Turn Count." }
}

private fun convertTurnCount(turnCountString: String): Int {
    return turnCountString.toInt()
}

private fun conductTurnForCars(raceCars: List<RaceCar>) {
    raceCars.forEach { it.move() }
}

private fun conductTurn(raceCars: List<RaceCar>) {
    conductTurnForCars(raceCars)
}

private fun displayTurnResult(raceCars: List<RaceCar>) {
    println(raceCars.joinToString("\n", postfix = "\n"))
}

private fun determineWinners(raceCars: List<RaceCar>): List<String> {
    val maxDistance = raceCars.maxOfOrNull { it.position } ?: 0
    return raceCars.filter { it.position == maxDistance }.map { it.name }
}


private fun displayWinners(raceCars: List<RaceCar>) {
    val winners = determineWinners(raceCars)
    println(winners.joinToString(", ", prefix = GameMessages.FINAL_WINNER_PREFIX))
}

private fun executeGame(raceCars: List<RaceCar>, turnCount: Int) {
    println("\n${GameMessages.TURN_RESULTS}")
    repeat(turnCount) {
        conductTurn(raceCars)
        displayTurnResult(raceCars)
    }
    displayWinners(raceCars)
}

fun main() {
    val raceCars = promptCarNames()
    val turnCount = promptTurnCount()
    executeGame(raceCars, turnCount)
}
