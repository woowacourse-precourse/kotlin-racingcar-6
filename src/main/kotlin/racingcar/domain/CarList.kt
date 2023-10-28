package racingcar.domain

import racingcar.model.Car
import racingcar.resources.Error.DUPLICATES_NAME_ERROR
import racingcar.resources.Error.NAME_LENGTH_ERROR
import racingcar.resources.Error.ZERO_CAR_ERROR
import racingcar.resources.ValidationValue.MAX_NAME_VALUE
import racingcar.resources.ValidationValue.MIN_CAR_COUNT_VALUE
import racingcar.resources.ValidationValue.MIN_NAME_VALUE

object CarList {

    fun userInputToCarList(userInput: String): List<Car> {
        return userInput.split(",").map { name ->
            Car(name = name)
        }.also { carsValidation(it) }
    }

    private fun carsValidation(racingCars : List<Car>) = with(racingCars) {
        require(size >= MIN_CAR_COUNT_VALUE) {
            ZERO_CAR_ERROR
        }

        require(all { (name, _) -> name.length in MIN_NAME_VALUE..MAX_NAME_VALUE }) {
            NAME_LENGTH_ERROR
        }

        require(map { car -> car.name }.toSet().size == this.size) {
            DUPLICATES_NAME_ERROR
        }
    }
}