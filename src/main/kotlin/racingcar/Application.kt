package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, private val randomGenerator: RandomGenerator) {
    var position = 0

    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun move() {
        val randomNumber = randomGenerator.generate()
    }
    fun printPosition() {
        println("$name : ${"-".repeat(position)}")
    }
}

class RacingGame(private val cars: List<Car>, private val tries: Int) {
    fun play() {
        repeat(tries) {
            cars.forEach { car ->
                if (RandomGenerator().generate() >= 4) {
                    car.move()
                }
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

class InputHandler {
    private val cars = mutableListOf<Car>()
    private val randomGenerator = RandomGenerator()

    fun start() {
        inputCarNames()
        inputCount()
    }
    private fun inputCarNames() {
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }
        cars.addAll(names.map { Car(it, randomGenerator) })
    }

    private fun inputCount(): Int? {
        return Console.readLine()?.toInt()
    }
}

class OutputHandler {
    fun printInputCarName() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun printInputCount() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printResult(result: Map<String, String>) {
        println("실행 결과")
        result.forEach { entry ->
            val eachResult = entry.key + " : " + entry.value
            println(eachResult)
        }
        println()
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
    // TODO: 프로그램 구현
    val inputHandler = InputHandler()
    inputHandler.start()
}
