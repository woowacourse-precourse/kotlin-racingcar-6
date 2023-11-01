package racingcar.model

import racingcar.config.ExceptionMessage.DUPLICATED_NAME

class Cars(val cars: List<Car>) {

    fun decideWinner(): List<String> {
        val maxPosition = cars.maxOf(Car::position)
        return cars.filter {
            it.position == maxPosition
        }.map(Car::name).toList()
    }

    fun validate() {
        validateDuplicate()
        cars.forEach(Car::validateCar)
    }

    internal fun validateDuplicate() {
        val set = cars.map(Car::name).toSet()
        if (cars.size > set.size) {
            throw IllegalArgumentException(DUPLICATED_NAME)
        }
    }

}