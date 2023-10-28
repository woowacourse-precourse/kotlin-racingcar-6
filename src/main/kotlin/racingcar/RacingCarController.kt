package racingcar

import racingcar.PlayerConsole.getValidCarNames

class RacingCarController {

    val carList = createRacingCars()
    val moveCount = PlayerConsole.getValidMoveCount()

    fun play() {
        createRacingCars()
        repeat(moveCount) {
            moveAllCars()
        }
    }

    private fun moveAllCars() {
        carList.forEach { it.moveForward() }
    }

    private fun createRacingCars() = getValidCarNames().map { RacingCar(it, 0) }

}