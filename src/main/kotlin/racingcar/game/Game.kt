package racingcar.game

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car
import racingcar.model.Cars
import racingcar.util.Constants.CAR_NAME_DELIMITER
import racingcar.util.Constants.TEXT_INPUT_CAR_NAME
import racingcar.util.Constants.TEXT_INPUT_ROUND
import racingcar.util.Constants.TEXT_PRINT_RESULT
import racingcar.util.Constants.TEXT_PRINT_WINNER
import racingcar.util.Validation.validateLength
import racingcar.util.Validation.validateNumberOfCars
import racingcar.util.Validation.validateDuplicateOfCars
import racingcar.util.Validation.validateRound

class Game {

    private lateinit var cars: Cars
    private var round: Int = 0

    fun startGame() {
        println(TEXT_INPUT_CAR_NAME)
        inputCarName()

        println(TEXT_INPUT_ROUND)
        inputRound()

        println("\n${TEXT_PRINT_RESULT}")
        printResult()

        printWinner()
    }

    private fun inputCarName() {
        val input = Console.readLine()
        cars = Cars(mapToCar(splitCarName(input)))
    }

    fun splitCarName(input: String): List<String> {
        val splitResult = mutableListOf<String>()

        input.split(CAR_NAME_DELIMITER).forEach {
            splitResult.add(validateLength(it))
        }

        validateNumberOfCars(splitResult)
        validateDuplicateOfCars(splitResult)

        return splitResult
    }

    private fun mapToCar(carList: List<String>): List<Car> {
        val mapResult = mutableListOf<Car>()
        carList.forEach {
            mapResult.add(Car(it, 0))
        }
        return mapResult
    }

    private fun inputRound() {
        val input = Console.readLine()
        round = validateRound(input)
    }

    private fun printResult() {
        for (turn in 1..round) {
            cars.moveAllCars()
            println()
        }
    }

    private fun printWinner() {
        val winners = cars.getWinner()
        println("$TEXT_PRINT_WINNER : ${winners.joinToString(", ")}")
    }
}