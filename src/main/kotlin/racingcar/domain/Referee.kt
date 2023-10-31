package racingcar.domain

class Referee(private val carList: List<Car>) {
    private var maxPosition = 0
    private var winningCarNames = mutableListOf<String>()

    init {
        setMaxDistance()
        setWinnerCarNames()
    }

    fun getWinningCarNames(): List<String> = winningCarNames

    private fun setMaxDistance() {
        carList.forEach {
            updateMaxDistance(it)
        }
    }

    private fun updateMaxDistance(car: Car) {
        maxPosition = maxPosition.coerceAtLeast(car.getPosition())
    }

    private fun setWinnerCarNames() {
        carList.forEach {
            addWinnerCar(it)
        }
    }

    private fun addWinnerCar(car: Car) {
        if (car.isWinner(maxPosition)) {
            winningCarNames.add(car.getName())
        }
    }
}