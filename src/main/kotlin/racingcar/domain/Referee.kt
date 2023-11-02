package racingcar.domain

class Referee(private val cars: List<Car>) {
    private var maxPosition: Int = 0
    private var winningCarNames: MutableList<String> = mutableListOf()

    init {
        setMaxDistance()
        setWinnerCarNames()
    }

    private fun setMaxDistance() {
        maxPosition = cars.maxOf { it.getPosition() }
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

    fun getWinningCarNames(): List<String> = winningCarNames
}