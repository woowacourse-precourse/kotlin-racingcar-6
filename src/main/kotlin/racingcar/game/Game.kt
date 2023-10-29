package racingcar.game

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car
import racingcar.model.Cars
import racingcar.util.Constants.CAR_NAME_DELIMITER
import racingcar.util.Constants.TEXT_START_GAME
import racingcar.util.Validation.validateLength
import racingcar.util.Validation.validateNumberOfCars
import racingcar.util.Validation.validateDuplicateOfCars

class Game {

    private lateinit var cars: Cars

    fun startGame() {
        println(TEXT_START_GAME)

        inputCarName()
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
}