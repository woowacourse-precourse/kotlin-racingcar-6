package racingcar

import racingcar.PlayerConsole.getValidCarNames

class RacingCarController {

    val carList = createRacingCars()
    val moveCount = PlayerConsole.getValidMoveCount()

    fun play() {
        createRacingCars()
        repeat(moveCount) {
            // TODO:전진
        }
    }

    private fun createRacingCars() = getValidCarNames().map { RacingCar(it, 0) }

}