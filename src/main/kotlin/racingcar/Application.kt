package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingCar(val name: String) {
    var position = 0
}

fun main() {
    try {
        val carNames = getCarNames()

    } catch (e: IllegalArgumentException) {
        println("에러: ${e.message}")
    }
}

fun getCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = readLine()?.split(",")?.map { it.trim() } ?: throw IllegalArgumentException("잘못된 입력입니다.")
    if (input.any { !it.matches(Regex("[a-zA-Z]+")) || it.length !in 1..5 }) {
        throw IllegalArgumentException("자동차 이름은 알파벳 문자로 이루어져 있고, 1자 이상 5자 이하만 가능합니다.")
    }
    return input
}

fun getTryCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return Console.readLine()?.toInt() ?: throw IllegalArgumentException("잘못된 입력입니다.")
}
