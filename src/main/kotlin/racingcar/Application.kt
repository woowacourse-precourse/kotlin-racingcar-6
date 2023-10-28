package racingcar

import camp.nextstep.edu.missionutils.Console

class Car(val name: String) {

}

class InputHandler {
    private val cars = mutableListOf<Car>()

    fun start() {
        inputCarNames()
    }
    private fun inputCarNames() {
        println("자동차 이름을 5자 이하로 입력해주세요.")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }
        cars.addAll(names.map { Car(it) })
    }
}

fun main() {
    // TODO: 프로그램 구현
    val inputHandler = InputHandler()
    inputHandler.start()
}
