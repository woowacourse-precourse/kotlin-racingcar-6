package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingPresenter {

    private val _racingCars = mutableListOf<RacingCar>()
    val racingCars: List<RacingCar> get() = _racingCars

    fun createRacingCarsOrThrow(rawInput: String) {
        val names = rawInput.split(",")
        names.forEach {
            val car = RacingCar.createOrThrow(it)
            _racingCars.add(car)
        }
    }

    fun moveRacingCars() {
        racingCars.forEach { car ->
            val random = Randoms.pickNumberInRange(
                MOVING_RANDOM_RANGE_START,
                MOVING_RANDOM_RANGE_END
            )
            if (random >= MOVING_THRESHOLD) {
                car.move()
            }
        }
    }

    companion object {
        private const val MOVING_RANDOM_RANGE_START = 0
        private const val MOVING_RANDOM_RANGE_END = 9
        private const val MOVING_THRESHOLD = 4
    }
}