package racingcar.domain

class Referee(private val cars: List<Car>) {
    private var maxPosition = 0
    private var winningCarNames = mutableListOf<String>()

    init {
        setMaxDistance()
        setWinnerCarNames()
    }

    fun getWinningCarNames(): List<String> = winningCarNames

    private fun setMaxDistance() {
        cars.forEach {
            updateMaxDistance(it)
        }
    }

    private fun updateMaxDistance(car: Car) {
        maxPosition = maxPosition.coerceAtLeast(car.getPosition())
    }

    private fun setWinnerCarNames() {
        cars.forEach {
            addWinnerCar(it)
        }
    }

    private fun addWinnerCar(car: Car) {
        if (car.isWinner(maxPosition)) {
            winningCarNames.add(car.getName())
        }
    }
}