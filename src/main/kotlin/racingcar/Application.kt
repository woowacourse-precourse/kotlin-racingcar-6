package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val player = mutableMapOf<String, Int>()
    for (name in parsingInput()) {
        player[name] = 0
    }
    println(player)
    println(inputNumber())
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


fun gameRunText(playerList: MutableMap<String, Int>) {
    for (player in playerList) {
        println("${player.key} : " + "-".repeat(player.value))
    }
}