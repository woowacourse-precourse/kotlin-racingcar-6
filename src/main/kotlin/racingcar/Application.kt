package racingcar

import camp.nextstep.edu.missionutils.Console

class Car(val name: String) {

}

class InputHandler {
    private val cars = mutableListOf<Car>()

    fun start() {
        inputCarNames()
        inputCount()
    }
    private fun inputCarNames() {
        println("자동차 이름을 5자 이하로 입력해주세요 (예: car1,car2,car3)")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }
        cars.addAll(names.map { Car(it) })
    }

    private fun inputCount(): Int? {
        return Console.readLine()?.toInt()
    }
}

fun main() {
    // TODO: 프로그램 구현
    val inputHandler = InputHandler()
    inputHandler.start()
}
