package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.model.RaceGame

fun main() {
    val carNames = getCarNames()
    val numberOfRacing = getNumberOfRacing()
    val raceGame = RaceGame(carNames, numberOfRacing)
    raceGame.start()
}

fun getCarNames(): String {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()
    if (input.isBlank()) throw IllegalArgumentException("공백만 입력 불가")
    return input
}

fun getNumberOfRacing(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val numberOfRacing = Console.readLine()
    println()
    if (!numberOfRacing.matches(Regex("\\d"))) throw IllegalArgumentException("숫자로 입력해야 함")
    return numberOfRacing.toInt()
}
