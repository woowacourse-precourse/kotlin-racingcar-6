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
        rackingCars = gameContinue(rackingCars, gameCount)
        gameResult(rackingCars)
    }

    private fun gameContinue(racingCars: List<RacingCar>, gameCount: Int): List<RacingCar> {
        outputView.printResult()

        repeat(gameCount) {
            racingCars.forEach { rackingCar ->
                rackingCar.addRacingCarDistance()
                outputView.printRackingCar(rackingCar)
            }
            outputView.printEnter()
        }
        return racingCars
    }

    private fun gameResult(racingCarList: List<RacingCar>) {
        val maxDistanceRackingCars = findMaxDistanceRacingCar(racingCarList)
        outputView.printMaxDistanceRacingCarName(maxDistanceRackingCars)
    }

    private fun findMaxDistanceRacingCar(racingCarList: List<RacingCar>): List<String> {
        return racingCarList.filter { racingCar -> racingCar.getDistance() == racingCarList.maxOf { it.getDistance() } }
            .map { it.racingCarName }
    }

}