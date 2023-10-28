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
        val winner = winnerNames.joinToString(", ")
        println("최종 우승자 : $winner")
    }

}