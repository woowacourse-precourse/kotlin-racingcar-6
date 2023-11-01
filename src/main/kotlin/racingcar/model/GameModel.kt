package racingcar.model

class GameModel(names: List<String>) {
    val cars: List<CarModel> = names.map { CarModel(it) }
    fun race() {
        cars.forEach {
            it.move(it.numberGenerator())
        }
    }

    fun getWinners(): List<CarModel> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}