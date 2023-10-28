package racingcar

import racingcar.PlayerConsole.getValidCarNames
import racingcar.PlayerConsole.getValidMoveCount

class RacingCarController {

    private val carList = createRacingCars(getValidCarNames())
    private val moveCount = getValidMoveCount()

    private fun createRacingCars(carNameList: List<String>) = carNameList.map { RacingCar(it, 0) }

    fun play() {
        repeat(moveCount) {
            moveAllCars()
            showResult()
        }
        finish()
    }

    private fun moveAllCars() {
        carList.forEach { it.moveForward() }
    }

    private fun showResult() {
        carList.forEach { it.printLocation() }
        println()
    }

    private fun finish() {
        val maxLocation = carList.maxBy { it.location }.location
        val winnerList = carList.filter { it.location == maxLocation }
        val finalWinner: List<String> = winnerList.map { it.name }
        val winnerNames = finalWinner.joinToString(", ")
        println("최종 우승자 : $winnerNames")
    }
}