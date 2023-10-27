package racingcar

import racingcar.constants.EXCEPTION_DUPLICATION
import racingcar.constants.MOVING_MORE_NUMBER
import racingcar.model.Car

class RacingGame {
    private val carList = mutableListOf<Car>()

    fun isMovingForward(number: Int): Boolean {
        return number >= MOVING_MORE_NUMBER
    }

    fun validateCarNameDuplication(racingCars: List<String>) {
        require(racingCars.size == racingCars.distinct().size) { EXCEPTION_DUPLICATION }
    }
}