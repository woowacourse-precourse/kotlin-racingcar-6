package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class RacingGame {
    private val cars: List<Car>
    private val tries: Int

    init {
        try {
            println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
            val input = Console.readLine()
            val names = input.split(",").map { it.trim() }
            require(names.all { it.length <= 5 }) { "자동차 이름은 5자를 초과할 수 없습니다." }
            cars = names.map { Car(it) }

            println("시도할 횟수는 몇 회인가요?")
            val inputTries = Console.readLine()
            tries = inputTries.toIntOrNull() ?: throw IllegalArgumentException("입력값이 정수가 아닙니다.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
            throw e
        }
    }

    fun play() {
        repeat(tries) {
            cars.forEach { car ->
                car.move()
                car.printPosition()
            }
            println()
        }

        val winners = findWinners()
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }

    private fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }

    private class Car(val name: String) {
        var position = 0
        private val randomGenerator = RandomGenerator()

        fun move() {
            if (randomGenerator.generate() >= 4) {
                position++
            }
        }

        fun printPosition() {
            println("$name : ${"-".repeat(position)}")
        }
    }

    private class RandomGenerator {
        fun generate(): Int {
            return Randoms.pickNumberInRange(0, 9)
        }
    }
}

fun main() {
    RacingGame().play()
}
