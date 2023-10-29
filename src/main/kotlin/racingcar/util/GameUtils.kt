package racingcar.util

import racingcar.data.RacingCarModel
import camp.nextstep.edu.missionutils.Console
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

    // 전진 여부
    private fun checkMoveForward() : Boolean{
        val randomValue = Randoms.pickNumberInRange(0, 9)
        val isMoving = randomValue >= 4
        return isMoving
    }

    // 라운드 횟수가 끝났는지 확인
    fun checkRoundEnded(isRoundEnded : Int) : Boolean{
        return isRoundEnded == 0
    }

    // 게임 종료 후 우승자를 판단해줄 함수
    fun findWinners(cars: List<RacingCarModel>): List<String> {
        val maxDistance = cars.maxBy{ it.moveForward }.moveForward
        val winners = cars.filter { it.moveForward == maxDistance }.map { it.carName }
        return winners
    }
    // 입력값(carNames) Parsing & Mapping
    fun mappingToCarList(input : String) = input.split(",").map { RacingCarModel(it.trim()) }
    
}

