package racingcar

import racingcar.PlayerConsole.getValidCarNames
import racingcar.PlayerConsole.getValidMoveCount

class RacingCarController {

    private val carList = createRacingCars(getValidCarNames())
    private val moveCount = getValidMoveCount()

    fun play() {
        repeat(moveCount) {
            moveAllCars()
            showResult()
        }
    }

    private fun moveAllCars() {
        carList.forEach { it.moveForward() }
    }

    private fun showResult() {
        carList.forEach { it.printLocation() }
        println()
    }

    private fun createRacingCars(carNameList: List<String>) = carNameList.map { RacingCar(it, 0) }

}