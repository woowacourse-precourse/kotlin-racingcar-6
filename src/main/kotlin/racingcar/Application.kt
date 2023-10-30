package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

data class CarRace(val name: String) {
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

private fun carNames(): String {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val inputCarNames = Console.readLine()

    if (inputCarNames.split(",").any { it.length > 5 }) {
        throw IllegalArgumentException()
    }
    return inputCarNames
}

private fun checkWin(): Int {
    println("시도할 횟수는 몇 회인가요?")

    return try {
        val attempts = Console.readLine().toInt()
        if (attempts <= 0) throw IllegalArgumentException()
        attempts
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException()
    }
}