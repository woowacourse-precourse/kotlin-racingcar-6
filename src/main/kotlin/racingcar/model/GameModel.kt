package racingcar.model

class GameModel(names: List<String>, private val attempts: Int) {
    private val cars: List<CarModel> = names.map { CarModel(it) }
    fun race() {
        repeat(attempts) {
            cars.forEach{ it.move() }
        }
    }

    fun getWinners(): List<CarModel> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}