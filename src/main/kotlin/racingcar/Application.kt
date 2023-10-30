package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class RaceCar(private val name: String, var position: Int = 0) {
    init {
        require((name.length <= 5)) { "Invalid Car Name." }
    }

    override fun toString(): String {
        return "$name : ${"-".repeat(position)}"
    }

}

fun moveDistance(): Int {
    return (Randoms.pickNumberInRange(0, 9).compareTo(4)).compareTo(-1)
}

private fun RaceCar.move() {
    position += moveDistance()
}

fun parseCarName(): List<RaceCar> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return Console.readLine().split(",").map { RaceCar(it.trim()) }
}

fun isNonnegativeInt(target: String): Boolean {
    return (target.isNotEmpty()) and (target.all { it.isDigit() })
}

fun parseTurnCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
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
    println("\n실행 결과")
    for (i in 1..turnCount) {
        turnProcess(raceCars)
        println(raceCars.joinToString("\n", postfix = "\n"))
    }
    val winners = decideWinners(raceCars)
    println(winners.joinToString(", ", "최종 우승자 : "))
}
