package racingcar.model

class GameModel(names: List<String>, private val attempts: Int) {
    val cars: List<CarModel> = names.map { CarModel(it) }
    fun race() {
        cars.forEach { it.move() }
    }

    fun getWinners(): List<CarModel> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}