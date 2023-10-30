package racingcar

import racingcar.Constants.CAR_NAME_SEPARATOR
import racingcar.Constants.MESSAGE_CAR_MINIMUM_REQUIRED
import racingcar.Constants.MESSAGE_DUPLICATE_CAR_NAME
import racingcar.Constants.MESSAGE_FINAL_WINNER
import racingcar.Constants.MINIMUM_CAR_NUMBER
import racingcar.Constants.START_POSITION
import racingcar.PlayerConsole.getValidCarNames
import racingcar.PlayerConsole.getValidMoveCount

class RacingCarController {

    private val carList = createRacingCars(getValidCarNames())
    private val moveCount = getValidMoveCount()

    private fun createRacingCars(carNameList: List<String>): List<RacingCar> {
        require(MINIMUM_CAR_NUMBER <= carNameList.size) { MESSAGE_CAR_MINIMUM_REQUIRED }
        require(carNameList.toSet().size == carNameList.size) { MESSAGE_DUPLICATE_CAR_NAME }
        return carNameList.map { RacingCar(it, START_POSITION) }
    }

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
        carList.forEach { it.printPosition() }
        println()
    }

    private fun finish() {
        val maxPosition: Int = getMaxPosition(carList)
        val finalWinner: List<String> = getWinnerNames(carList, maxPosition)
        printWinnerNames(finalWinner)
    }

    private fun getMaxPosition(carList: List<RacingCar>) = carList.maxBy { it.position }.position

    private fun getWinnerNames(carList: List<RacingCar>, maxPosition: Int): List<String> {
        val winnerList = carList.filter { it.position == maxPosition }
        return winnerList.map { it.name }
    }

    private fun printWinnerNames(winnerNames: List<String>) {
        val winner = winnerNames.joinToString(CAR_NAME_SEPARATOR)
        println(MESSAGE_FINAL_WINNER + winner)
    }

}