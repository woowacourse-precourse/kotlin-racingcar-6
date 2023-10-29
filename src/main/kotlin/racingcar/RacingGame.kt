package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.constants.EXCEPTION_DUPLICATION
import racingcar.constants.MOVING_MORE_NUMBER
import racingcar.constants.RANDOM_END_NUMBER
import racingcar.constants.RANDOM_START_NUMBER
import racingcar.io.inputRacingCars
import racingcar.io.inputTryCount
import racingcar.io.printCarListResult
import racingcar.io.printWinner
import racingcar.model.Car
import racingcar.model.Try
import racingcar.util.toCarList

class RacingGame {
    private lateinit var carList: List<Car>
    
    private fun progressGameStep() {
        carList.forEach { car ->
            val random = Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER)
            if (isMovingForward(random)) {
                car.moveForward()
            }
        }

    }

    fun isMovingForward(number: Int): Boolean {
        return number >= MOVING_MORE_NUMBER
    }

    fun pickWinner(carList: List<Car>): List<Car> {
        val winnerForwardCount = carList.sorted()[0].forwardCount
        return carList.filter { car -> car.forwardCount == winnerForwardCount }
    }

    fun validateCarNameDuplication(racingCars: List<String>) {
        require(racingCars.size == racingCars.distinct().size) { EXCEPTION_DUPLICATION }
    }
}