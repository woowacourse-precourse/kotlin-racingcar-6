package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val player = mutableMapOf<String, Int>()
    for (name in parsingInput()) {
        player[name] = 0
    }
    println(player)
}

fun parsingInput(): List<String> {
    val inputText: String = Console.readLine()
    validateNameLength(inputText.split(","))
    return inputText.split(",")
}

fun validateNameLength(input: List<String>) {
    for (name in input) {
        if (name.length > 4) throw IllegalArgumentException("${name}의 길이가 5이상 입니다.")
        validateNameIsNotInt(name)
    }
}

fun validateNameIsNotInt(input: String) {
    if (input.toIntOrNull() != null) throw IllegalArgumentException("${input}은 숫자입니다.")
}

