package racingcar

import racingcar.PlayerConsole.getValidCarNames

class RacingCarController {

    val carList = createRacingCars()

    private fun createRacingCars() = getValidCarNames().map { RacingCar(it, 0) }

}