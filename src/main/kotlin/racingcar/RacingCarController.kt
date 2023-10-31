package racingcar

import racingcar.Constants.MESSAGE_CAR_MINIMUM_REQUIRED
import racingcar.Constants.MESSAGE_DUPLICATE_CAR_NAME
import racingcar.Constants.MINIMUM_CAR_NUMBER
import racingcar.GameConsole.printCarNamePrompt
import racingcar.GameConsole.printMoveCountPrompt
import racingcar.GameConsole.printPosition
import racingcar.GameConsole.printWinnerNames
import racingcar.PlayerConsole.getValidCarNames
import racingcar.PlayerConsole.getValidMoveCount

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

}