package racingcar.util

import racingcar.data.RacingCarModel
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object GameUtils {

    fun updateCarsState(carList: List<RacingCarModel>): List<RacingCarModel> {
        val updatedCars = mutableListOf<RacingCarModel>()

        for (car in carList) {
            val isMoveForward = checkMoveForward()

            val updatedCar = if (isMoveForward) {
                RacingCarModel(car.carName, car.moveForward + 1)
            } else {
                RacingCarModel(car.carName, car.moveForward)
            }
            updatedCars.add(updatedCar)
        }
        return updatedCars
    }

    private fun checkMoveForward() : Boolean{
        val randomValue = Randoms.pickNumberInRange(0, 9)
        val isMoving = randomValue >= 4
        return isMoving
    }
}

