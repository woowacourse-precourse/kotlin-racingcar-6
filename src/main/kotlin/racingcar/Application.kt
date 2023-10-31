package racingcar

import camp.nextstep.edu.missionutils.Console

class InputHandler {
    fun start() {
        getCarNames()
    }

    private fun getCarNames() {
        println("경주할 자동차 이름을 5자 이하로 입력해주세요.")
        val input = Console.readLine()
        val carNames = input.split(",").map { it.trim() }

        println("입력한 자동차 이름:")
        carNames.forEach { println("$it:") }
    }
}

fun main() {
    val inputHandler = InputHandler()
    inputHandler.start()
}