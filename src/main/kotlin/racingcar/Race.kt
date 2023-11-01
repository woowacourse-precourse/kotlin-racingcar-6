package racingcar

class Race {

    fun startRace(cars: List<Car>, moveTime: Int) {

    }

    private fun viewRace(cars: List<Car>) {
        cars.forEach { it.printCarMove() }
    }
}