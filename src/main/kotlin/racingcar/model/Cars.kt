package racingcar.model

data class Cars(val cars: List<Car>) {
    init {
        require(cars.size == cars.distinct().size) { DUPLICATED_CARS }
    }

    companion object {
        const val DUPLICATED_CARS = "자동차에 중복된 이름이 있습니다."
    }
}