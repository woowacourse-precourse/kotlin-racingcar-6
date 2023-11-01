package racingcar.controller

import racingcar.model.RacingCar
import racingcar.model.RacingCarService.createRacingCars
import racingcar.model.RacingCarService.getMaxPosition
import racingcar.model.RacingCarService.getWinnerNames
import racingcar.model.RacingCarService.moveAllCars
import racingcar.view.GameConsole
import racingcar.view.GameConsole.printWinnerNames
import racingcar.view.PlayerConsole.getValidCarNames
import racingcar.view.PlayerConsole.getValidMoveCount

class RacingCarController {

    private val carList: List<RacingCar> = createRacingCars(getValidCarNames())
    private val moveCount: Int = getValidMoveCount()

    fun play() {
        repeat(moveCount) {
            moveAllCars(carList)
            showResult(carList)
        }
        finish()
    }

    private fun showResult(carList: List<RacingCar>) {
        carList.forEach { GameConsole.printPosition(it.name, it.position) }
        println()
    }

    private fun finish() {
        val finalWinners = getWinnerNames(carList, getMaxPosition(carList))
        printWinnerNames(finalWinners)
    }
}
