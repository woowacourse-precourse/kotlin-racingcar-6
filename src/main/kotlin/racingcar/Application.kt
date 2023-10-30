package racingcar

import camp.nextstep.edu.missionutils.Console

class raceCar(private val name: String, private val position: Int = 0) {
    init {
        require((name.length <= 5)) { "Invalid Car Name." }
    }

    override fun toString(): String {
        return "$name : ${"-".repeat(position)}"
    }
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
    require(isNonnegativeInt(turnCountString), "Invalid Turn Count.")
    return turnCountString.toInt()
}

fun main() {
    val raceCars = parseCarName()
    val turnCount = parseTurnCount()
}
