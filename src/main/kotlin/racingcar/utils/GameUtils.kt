package racingcar.utils

import racingcar.data.model.RacingCarModel
import camp.nextstep.edu.missionutils.Randoms

object GameUtils {

    // 라운드마다 전진 상태 업데이트
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

    private fun checkMoveForward(): Boolean {
        val randomValue = Randoms.pickNumberInRange(0, 9)
        return randomValue >= 4
    }

    fun checkRoundEnded(isRoundEnded: Int): Boolean {
        return isRoundEnded == 0
    }

    fun findWinners(cars: List<RacingCarModel>): List<String> {
        val maxDistance = cars.maxBy { it.moveForward }.moveForward
        return cars.filter { it.moveForward == maxDistance }.map { it.carName }
    }

    // 입력값(carNames)을 List의 형태로 Parsing & Mapping
    fun mappingToCarList(input: String): List<RacingCarModel> {
        return input.split(",").map {
            RacingCarModel(carName = it.trim(), moveForward = 0)
        }
    }

}

