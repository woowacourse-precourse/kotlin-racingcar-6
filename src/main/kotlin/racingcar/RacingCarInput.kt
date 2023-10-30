package racingcar

import racingcar.Converter.convertStringToCars
import racingcar.ErrorMessage.CAR_MINIMUM_COUNT_ERROR
import racingcar.ErrorMessage.CAR_NAME_LENGTH_OVER_ERROR
import racingcar.ErrorMessage.DUPLICATE_CAR_NAME_ERROR
import racingcar.GameMessage.INPUT_RACING_CAR_NAME_MESSAGE
import racingcar.UserInput.getUserInput

object RacingCarInput {
    private const val MIN_CAR_COUNT = 1
    private const val MAX_CAR_NAME_LENGTH = 5


    fun getCarNames(): List<Car> {
        println(INPUT_RACING_CAR_NAME_MESSAGE)
        val userInput = getUserInput()
        return runCatching {
            convertStringToCars(userInput).apply { validate(this) }
        }.getOrElse { throwable ->
            throw IllegalArgumentException(throwable)
        }
    }

    private fun validate(cars: List<Car>) {
        validateCarNameDuplicate(cars)
        validateMinimumCarCount(cars)
        validateCarNameLength(cars)
    }

    private fun validateCarNameDuplicate(cars: List<Car>) {
        val carNames = cars.map { it.name }
        if (carNames.size != carNames.distinct().size) {
            throw IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR)
        }
    }

    private fun validateMinimumCarCount(cars: List<Car>) {
        if (cars.size <= MIN_CAR_COUNT) {
            throw IllegalArgumentException(CAR_MINIMUM_COUNT_ERROR)
        }
    }

    private fun validateCarNameLength(cars: List<Car>) {
        for (car in cars) {
            validateLength(car.name)
        }
    }

    private fun validateLength(carName: String) {
        if (carName.length > MAX_CAR_NAME_LENGTH) {
            throw IllegalArgumentException(CAR_NAME_LENGTH_OVER_ERROR)
        }
    }

}
