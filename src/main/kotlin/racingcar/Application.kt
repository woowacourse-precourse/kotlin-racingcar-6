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

    return inputText.split(",")
}


