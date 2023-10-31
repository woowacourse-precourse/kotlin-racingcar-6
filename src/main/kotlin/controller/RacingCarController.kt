package controller

import model.RacingCar
import model.RandomMoveStrategy
import view.GameConsole.printCarNamePrompt
import view.GameConsole.printMoveCountPrompt
import view.GameConsole.printPosition
import view.GameConsole.printWinnerNames
import view.PlayerConsole.getValidCarNames
import view.PlayerConsole.getValidMoveCount

class RacingCarController {

    private val carList: List<RacingCar>
    private val moveCount: Int


    init {
        printCarNamePrompt()
        carList = createRacingCars(getValidCarNames())

        printMoveCountPrompt()
        moveCount = getValidMoveCount()
    }

    private fun createRacingCars(carNameList: List<String>): List<RacingCar> {
        require(MINIMUM_CAR_NUMBER <= carNameList.size) { MESSAGE_CAR_MINIMUM_REQUIRED }
        require(carNameList.toSet().size == carNameList.size) { MESSAGE_DUPLICATE_CAR_NAME }
        return carNameList.map { RacingCar(it, moveStrategy = RandomMoveStrategy()) }
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
        carList.forEach { printPosition(it.name, it.position) }
        println()
    }

    private fun finish() {
        val maxPosition: Int = getMaxPosition(carList)
        val finalWinners: List<String> = getWinnerNames(carList, maxPosition)
        printWinnerNames(finalWinners)
    }

    private fun getMaxPosition(carList: List<RacingCar>) = carList.maxBy { it.position }.position

    private fun getWinnerNames(carList: List<RacingCar>, maxPosition: Int): List<String> {
        val winnerList = carList.filter { it.position == maxPosition }
        return winnerList.map { it.name }
    }

    companion object {
        const val MINIMUM_CAR_NUMBER = 2
        const val MESSAGE_CAR_MINIMUM_REQUIRED = "2대 이상의 자동차가 필요합니다."
        const val MESSAGE_DUPLICATE_CAR_NAME = "자동차 이름은 서로 중복될 수 없습니다."
    }
}
