package racingcar.domain

class Referee(private val circuit: Circuit) {
    private var maxDistance = 0
    private var winnerCarNames = mutableListOf<String>()

    init {
        findMaxDistance()
        findWinnerCarNames()
    }

    fun getWinnerCarNames() = winnerCarNames

    private fun findMaxDistance() {
        circuit.getCarList().forEach {
            if (it.getPosition() > maxDistance) {
                maxDistance = it.getPosition()
            }
        }
    }

    private fun findWinnerCarNames(){
        circuit.getCarList().forEach {
            if (it.isWinnerCar(maxDistance)) {
                winnerCarNames.add(it.getName())
            }
        }
    }
}