package racingcar.model

import racingcar.config.ExceptionMessage.DUPLICATED_NAME

class Cars(val carList: List<Car>) {

    fun decideWinner(): List<String> {
        val maxPosition = carList.maxOf(Car::position)
        return carList.filter {
            it.position == maxPosition
        }.map(Car::name).toList()
    }

    fun validate() {
        validateDuplicate()
        carList.forEach(Car::validateCar)
    }

    internal fun validateDuplicate() {
        val set = carList.map(Car::name).toSet()
        if (carList.size > set.size) {
            throw IllegalArgumentException(DUPLICATED_NAME)
        }
    }

    override fun toString(): String {
        return "Cars(carList=$carList)"
    }

}