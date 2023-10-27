package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RacingCarMover {

    fun moveRacingCars(racingCars: RacingCars): RacingCars {
        racingCars.loadRacingCars().forEach {
            if (generateRandomNumber() >= BOUNDARY_NUMBER) {
                it.addForwardCount()
            }
        }
        return racingCars
    }

    private fun generateRandomNumber(): Int = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)

    companion object {
        private const val BOUNDARY_NUMBER = 4
        private const val MIN_NUMBER = 0
        private const val MAX_NUMBER = 9
    }
}