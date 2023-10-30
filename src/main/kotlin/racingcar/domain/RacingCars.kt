package racingcar.domain

class RacingCars(names: List<String>) {
    private val cars: List<RacingCar>

    init {
        require(names.size >= MIN_CARS_SIZE) { "자동차는 최소 ${MIN_CARS_SIZE}대 이상이어야 합니다." }
        cars = names.map { RacingCar(it) }
    }

    companion object {
        private const val MIN_CARS_SIZE = 2
    }
}
