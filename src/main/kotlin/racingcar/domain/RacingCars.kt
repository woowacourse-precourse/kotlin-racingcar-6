package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RacingCars private constructor(private val cars: List<RacingCar>) {
    init {
        require(cars.size >= MINIMUM_NUMBER_OF_CARS) { "자동차는 최소 ${MINIMUM_NUMBER_OF_CARS}대 이상이어야 합니다." }
    }

    fun move() {
        cars.forEach { it.move(Randoms.pickNumberInRange(0, 9)) }
    fun move() = cars.forEach { it.move(Randoms.pickNumberInRange(0, 9)) }
    }

    companion object {
        private const val MINIMUM_NUMBER_OF_CARS = 2

        fun fromNames(names: List<String>) = RacingCars(names.map { RacingCar(it) })

        fun fromCars(cars: List<RacingCar>) = RacingCars(cars)
    }
}
