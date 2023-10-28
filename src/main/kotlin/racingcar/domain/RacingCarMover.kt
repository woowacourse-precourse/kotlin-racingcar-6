package racingcar.domain

import racingcar.util.RandomNumberGenerator

class RacingCarMover {

    fun moveRacingCars(racingCars: RacingCars): RacingCars {
        racingCars.loadRacingCars().forEach {
            if (RandomNumberGenerator.generateRandomNumber() >= BOUNDARY_NUMBER) {
                it.addForwardCount()
            }
        }
        return racingCars
    }


    companion object {
        private const val BOUNDARY_NUMBER = 4
    }
}