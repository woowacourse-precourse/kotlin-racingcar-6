package racingcar.model

data class Cars(val cars: List<Car>) {
    init {
        require(cars.size == cars.distinct().size) { DUPLICATED_CARS }
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    companion object {
        fun withNames(vararg carNames: String): Cars {
            val carsList = carNames.map { Car(it) }
            return Cars(carsList)
        }

        const val DUPLICATED_CARS = "자동차에 중복된 이름이 있습니다."
    }
}