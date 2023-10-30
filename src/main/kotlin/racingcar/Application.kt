package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class raceCar(private val name: String, var position: Int = 0) {
    init {
        require((name.length <= 5)) { "Invalid Car Name." }
    }

    override fun toString(): String {
        return "$name : ${"-".repeat(position)}"
    }

}

fun isMovable(): Int {
    return (Randoms.pickNumberInRange(0, 9) >= 4)
}

private fun raceCar.move() {
    position += isMovable()
}

fun parseCarName(): List<raceCar> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return Console.readLine().split(",").map { raceCar(it.trim()) }
}

fun isNonnegativeInt(target: String): Boolean {
    return (target.size >= 1) and (target.all { it.isDigit() })
}

fun parseTurnCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val turnCountString = Console.readLine()
    require(isNonnegativeInt(turnCountString)) { "Invalid Turn Count." }
    return turnCountString.toInt()
}

fun turnProcess(raceCars: List<raceCar>) {
    for (raceCar in raceCars) {
        raceCar.move()
    }
}

fun main() {
    val raceCars = parseCarName()
    val turnCount = parseTurnCount()
    println("\n실행 결과")
    for (i in 1..turnCount) {
        turnProcess(raceCars)
        println(raceCars.joinToString("\n", postfix = "\n"))
    }
}
