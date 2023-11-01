package racingcar.controller

import racingcar.model.RacingCar
import racingcar.model.RacingCars
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {

    private val inputView = InputView()
    private val outputView = OutputView()

    fun playGame() {
        val users = inputView.getInputCarName()
        var racingCars = convertUsersToRacingCars(users)

        val gameCount = inputView.getInputGameCount()
        racingCars = getGameResultRacingCars(racingCars, gameCount)

        gameEnd(racingCars)
    }

    private fun convertUsersToRacingCars(users: List<String>): List<RacingCar> =
        users.map { RacingCar(it, INIT_DISTANCE_NUM) }


    private fun getGameResultRacingCars(racingCars: List<RacingCar>, gameCount: Int): List<RacingCar> {
        outputView.printResult()

        repeat(gameCount) {
            gameContinue(racingCars)
            outputView.printEnter()
        }
        return racingCars
    }

    private fun gameContinue(racingCars: List<RacingCar>) {
        racingCars.forEach { racingCar ->
            racingCar.addRacingCarDistance()
            outputView.printRacingCar(racingCar)
        }
    }

    private fun gameEnd(racingCarList: List<RacingCar>) {
        val maxDistanceRacingCars = findMaxDistanceRacingCar(racingCarList)
        outputView.printMaxDistanceRacingCarName(maxDistanceRacingCars)
    }

    fun findMaxDistanceRacingCar(racingCarList: List<RacingCar>): List<String> {
        return RacingCars(racingCarList).getMaxDistanceCar().map { it.racingCarName }
    }

    companion object {
        private const val INIT_DISTANCE_NUM = 0
    }
}