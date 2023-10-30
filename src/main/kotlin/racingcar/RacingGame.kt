package racingcar

import camp.nextstep.edu.missionutils.Console

class RacingGame {
    private val exception = Exception()

    fun gameStart() {
        val cars = initCar()
        val roundCount = readRounds()
        printResult(roundCount, cars)
    }

    private fun printResult(roundCount: Int, cars: List<Car>) {
        println("실행 결과")
        repeat(roundCount) {
            cars.forEach { car ->
                car.moving()
                car.printPosition()
            }
            println()
        }
    }

    fun initCar(): List<Car> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val name = readCarNames()
        exception.nameValidation(name)
        return name.map { Car(it) }
    }

    fun readCarNames(): List<String> {
        val input = Console.readLine()
        return input.split(",")
    }

    fun readRounds(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine()
        return exception.roundsValidation(input)
    }
}