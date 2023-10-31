package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)")
    val carNames = readCarNames()
    val game = RacingGame(carNames)

    println("시도할 횟수는 몇 회인가요?")
    val tryCount = readTryCount()

    game.racing(tryCount)
}

fun readCarNames(): List<String> {
    val input = Console.readLine()

    if (input == "") {
        throw IllegalArgumentException("자동차 이름이 입력되지 않았습니다.")
    }

    val carNames = input.split(",").map { it.trim() }

    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
    }

    return carNames
}

fun readTryCount(): Int {
    val input = Console.readLine()
    try {
        return input.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("올바른 숫자를 입력하세요.")
    }
}

