package racingcar.raceModel

class Race(val cars: List<Car>) {
    fun run() {
        cars.forEach { it.move() }
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}