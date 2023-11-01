package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    game()

}

fun parsingInput(): List<String> {
    val inputText: String = Console.readLine()
    validateNameLength(inputText.split(","))
    return inputText.split(",")
}

fun inputNumber(): Int {
    val inputText: String = Console.readLine()
    return validateNumber(inputText)
}

fun validateNameLength(input: List<String>) {
    for (name in input) {
        if (name.length > 5) throw IllegalArgumentException("${name}의 길이가 6이상 입니다.")
        if (name.isEmpty()) throw IllegalArgumentException("${name}의 길이가 0 입니다.")
        validateNameIsNotInt(name)
    }
}

fun validateNameIsNotInt(input: String) {
    if (input.toIntOrNull() != null) throw IllegalArgumentException("${input}은 숫자입니다.")
}

fun validateNumber(input: String): Int {
    if (input.toIntOrNull() == null) throw IllegalArgumentException("${input}은 정수가 아닙니다.")
    validateIsPositiveInteger(input.toInt())
    return input.toInt()
}

fun validateIsPositiveInteger(input: Int) {
    if (input < 0) throw IllegalArgumentException("${input}은 0보다 작은 횟수로 입력이 불가능합니다.")
}

fun game() {
    val playerList = mutableMapOf<String, Int>()
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    for (name in parsingInput()) {
        playerList[name] = 0
    }
    println("시도할 횟수는 몇 회인가요?")
    val runtime = inputNumber()
    for (time: Int in 0..runtime) {
        gameMain(playerList)
    }
}

fun gameMain(playerList: MutableMap<String, Int>) {
    var run: Int
    for (name in playerList.keys) {
        run = Randoms.pickNumberInRange(0, 9)
        if (run >= 4) playerList[name] = playerList.getValue(name) + 1
        gameRunText(name, playerList.getValue(name))
    }
    println()
}

fun gameRunText(name: String, runtime: Int) {
    println("${name} : " + "-".repeat(runtime))
}
