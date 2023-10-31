package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.car.Car
import racingcar.car.MoveStrategyImpl
import racingcar.game.Round

class RaceGame {
    private var cars = listOf<Car>()
    private var rounds = 0

    init {
        println(INPUT_CARS_MESSAGE)
        cars = generateContenders()

        println(INPUT_ROUNDS_MESSAGE)
        rounds = generateRounds()
    }

    private fun generateContenders(): List<Car> = Console.readLine()
        .split(",")
        .toCarList()

    private fun generateRounds(): Int = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException()

    private fun List<String>.toCarList(): List<Car> {
        return this.map { name ->
            if (name.length > MAX_CAR_NAME_LENGTH) throw IllegalArgumentException()
            if (name == "") throw IllegalArgumentException()

            Car(name, MoveStrategyImpl())
        }
    }

    fun start() {
        println(RESULT_ROUND_MESSAGE)
        val round = Round(cars)
        repeat(rounds) {
            round.start()
            round.printResult()
        }
    }

    fun printGameWinners() {
        print(WINNER_MESSAGE)
        val winners = findWinners(cars).joinToString(", ") { car -> car.name }
        println(winners)
    }

    private fun findWinners(cars: List<Car>): List<Car> {
        val maxForward = cars.maxByOrNull { car ->
            car.forward
        }?.forward
        return cars.filter { car ->
            car.forward == maxForward
        }
    }

    companion object {
        const val MAX_CAR_NAME_LENGTH = 5
    }
}
