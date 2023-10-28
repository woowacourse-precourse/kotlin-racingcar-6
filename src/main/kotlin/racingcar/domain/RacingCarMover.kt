package racingcar.domain

import racingcar.constant.ErrorMessage
import racingcar.util.RandomNumberGenerator

class RacingCarMover {

    fun moveRacingCars(racingCars: RacingCars): RacingCars {
        validateNameListSize(racingCars)
        validateNameLength(racingCars)
        racingCars.loadRacingCars().forEach {
            if (RandomNumberGenerator.generateRandomNumber() >= BOUNDARY_NUMBER) {
                it.addForwardCount()
            }
        }
        return racingCars
    }

    private fun validateNameListSize(racingCars: RacingCars) {
        require(racingCars.loadRacingCars().size >= MIN_RACING_CAR_COUNT) { ErrorMessage.RACING_CAR_LESS_THAN_TWO.message }
    }

    private fun validateNameLength(racingCars: RacingCars) {
        validateCarNamesLength(racingCars)
    }

    private fun validateCarNamesLength(racingCars: RacingCars) {
        require(
            racingCars.loadRacingCars()
                .none { it.readRacingCarName().length > MAX_NAME_LENGTH }) { ErrorMessage.NAME_LENGTH_GREATER_THAN_FIVE }
    }


    companion object {
        private const val BOUNDARY_NUMBER = 4
        private const val MAX_NAME_LENGTH = 5
        private const val MIN_RACING_CAR_COUNT = 2
    }
}