package racingcar

import racingcar.PlayerConsole.getValidCarNames
import racingcar.PlayerConsole.getValidMoveCount

class RacingCarController {

    val carList = createRacingCars(getValidCarNames())
    val moveCount = getValidMoveCount()

    fun play() {
        repeat(moveCount) {
            moveAllCars()
        }
    }

    private fun moveAllCars() {
        carList.forEach { it.moveForward() }
    }

    private fun createRacingCars(carNameList: List<String>) = carNameList.map { RacingCar(it, 0) }

}