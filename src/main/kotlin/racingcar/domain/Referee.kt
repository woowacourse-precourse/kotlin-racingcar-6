package racingcar.domain

class Referee(private val circuit: Circuit) {
    private var maxDistance = 0
    private var winningCarNames = mutableListOf<String>()

    init {
        setMaxDistance()
        setWinnerCarNames()
    }

    fun getWinningCarNames(): MutableList<String> = winningCarNames

    private fun setMaxDistance() {
        circuit.getCarList().forEach {
            updateMaxDistance(it)
        }
    }

    private fun updateMaxDistance(car: Car) {
        if (car.getPosition() > maxDistance) {
            maxDistance = car.getPosition()
        }
    }

    private fun setWinnerCarNames() {
        circuit.getCarList().forEach {
            addWinnerCar(it)
        }
    }

    private fun addWinnerCar(car: Car) {
        if (car.isWinnerCar(maxDistance)) {
            winningCarNames.add(car.getName())
        }
    }
}