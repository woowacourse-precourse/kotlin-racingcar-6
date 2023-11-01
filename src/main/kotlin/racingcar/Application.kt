package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class InputHandler {
    fun start() {
        val carNames = getCarNames()
        val roundCount = getRoundCount()
        val cars = carNames.map { Car(it) }

        println("실행 결과")
        repeat(roundCount) {
            cars.forEach { car ->
                car.move()
                println("${car.name}: ${car.getPosition()}")
            }
            println()
        }
    }

    private fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력해주세요(이름은 (,)를 기준으로 구분)")
        val input = Console.readLine()
        val carNames = input.split(",").map { it.trim() }
        if (carNames.any { it.length > 5 }) {
            throw IllegalArgumentException("자동차 이름을 5자 이하로 입력해주세요.")
        }
        return carNames
    }

    private fun getRoundCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine()
        if (!input.matches(Regex("-?\\d+"))) {
            throw IllegalArgumentException("정수만 입력할 수 있습니다.")
        }
        return input.toIntOrNull() ?: 0
    }

    private class Car(val name: String) {
        private var position = 0

        fun move() {
            val randomValue = RandomGenerator.generate()
            if (randomValue >= 4) {
                position++
            }
        }

        fun getPosition(): String {
            return "-".repeat(position)
        }
    }

    private object RandomGenerator {
        fun generate(): Int {
            return Randoms.pickNumberInRange(0, 9)
        }
    }
}

fun main() {
    val inputHandler = InputHandler()
    inputHandler.start()
}
