package racingcar.controller

import racingcar.model.RacingCar
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {

    private val inputView = InputView()
    private val outputView = OutputView()

    fun playGame() {
        var rackingCars = inputView.printInputCarName()
        val gameCount = inputView.printInputGameCount()
        rackingCars = getGameResultRacingCars(rackingCars, gameCount)
        gameEnd(rackingCars)
    }

    private fun getGameResultRacingCars(racingCars: List<RacingCar>, gameCount: Int): List<RacingCar> {
        outputView.printResult()

        repeat(gameCount) {
            gameContinue(racingCars)
            outputView.printEnter()
        }
        return racingCars
    }

    private fun gameContinue(racingCars: List<RacingCar>) {
        racingCars.forEach { rackingCar ->
            rackingCar.addRacingCarDistance()
            outputView.printRackingCar(rackingCar)
        }
    }

    private fun gameEnd(racingCarList: List<RacingCar>) {
        val maxDistanceRackingCars = findMaxDistanceRacingCar(racingCarList)
        outputView.printMaxDistanceRacingCarName(maxDistanceRackingCars)
    }

    private fun findMaxDistanceRacingCar(racingCarList: List<RacingCar>): List<String> {
        return racingCarList.filter { racingCar -> racingCar.getDistance() == racingCarList.maxOf { it.getDistance() } }
            .map { it.racingCarName }
    }

}