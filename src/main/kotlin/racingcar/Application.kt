package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, private val randomGenerator: RandomGenerator) {
    var position = 0

    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun move() {
        if (randomGenerator.generate() >= 4) {
            position++
        }
    }

    fun printPosition() {
        println("$name : ${"-".repeat(position)}")
    }
}

class RacingGame(private val cars: List<Car>, private val tries: Int) {
    fun play() {
        repeat(tries) {
            cars.forEach { car ->
                car.move()
                car.printPosition()
            }
            println()
        }
    }

    fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}

class InputHandler(private val randomGenerator: RandomGenerator) {
    fun getCars(): List<Car> {
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }
        return names.map { Car(it, randomGenerator) }
    }

    fun getTries(): Int {
        val input = Console.readLine()
        return input.toIntOrNull() ?: throw IllegalArgumentException("입력값이 정수가 아닙니다.")
    }
}

class OutputHandler {
    fun printInputCarName() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun printInputCount() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printWinner(winners: List<String>) {
        println("최종 우승자: " + winners.joinToString(", "))
    }
}

class RandomGenerator {
    fun generate(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}

fun main() {
    try {
        val randomGenerator = RandomGenerator()
        val inputHandler = InputHandler(randomGenerator)
        val outputHandler = OutputHandler()

        outputHandler.printInputCarName()
        val cars = inputHandler.getCars()

        outputHandler.printInputCount()
        val tries = inputHandler.getTries()

        val game = RacingGame(cars, tries)
        game.play()

        val winners = game.findWinners()
        outputHandler.printWinner(winners)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
