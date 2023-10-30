package racingcar

import racingcar.Constants.CAR_NAME_SEPARATOR
import racingcar.Constants.MESSAGE_CAR_MINIMUM_REQUIRED
import racingcar.Constants.MESSAGE_DUPLICATE_CAR_NAME
import racingcar.Constants.MESSAGE_FINAL_WINNER
import racingcar.Constants.MINIMUM_CAR_NUMBER
import racingcar.Constants.START_LOCATION
import racingcar.PlayerConsole.getValidCarNames
import racingcar.PlayerConsole.getValidMoveCount

class RacingCarController {

    private val carList = createRacingCars(getValidCarNames())
    private val moveCount = getValidMoveCount()

    private fun createRacingCars(carNameList: List<String>): List<RacingCar> {
        require(MINIMUM_CAR_NUMBER <= carNameList.size) { MESSAGE_CAR_MINIMUM_REQUIRED }
        require(carNameList.toSet().size == carNameList.size) { MESSAGE_DUPLICATE_CAR_NAME }
        return carNameList.map { RacingCar(it, START_LOCATION) }
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
        carList.forEach { it.printLocation() }
        println()
    }

    private fun finish() {
        val maxLocation: Int = getMaxLocation(carList)
        val finalWinner: List<String> = getWinnerNames(carList, maxLocation)
        printWinnerNames(finalWinner)
    }

    private fun getMaxLocation(carList: List<RacingCar>) = carList.maxBy { it.location }.location

    private fun getWinnerNames(carList: List<RacingCar>, maxLocation: Int): List<String> {
        val winnerList = carList.filter { it.location == maxLocation }
        return winnerList.map { it.name }
    }

    private fun printWinnerNames(winnerNames: List<String>) {
        val winner = winnerNames.joinToString(CAR_NAME_SEPARATOR)
        println(MESSAGE_FINAL_WINNER + winner)
    }

}