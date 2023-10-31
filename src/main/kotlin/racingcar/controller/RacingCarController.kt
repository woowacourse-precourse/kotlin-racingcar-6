package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
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

    private fun gameContinue(rackingCars: List<RacingCar>, gameCount: Int): List<RacingCar> {
        outputView.printResult()

        repeat(gameCount) {
            rackingCars.forEach {
                addRacingCarDistance(it)
            }
            outputView.printEnter()
        }

        return rackingCars
    }

    private fun gameResult(racingCarList: List<RacingCar>) {
        val maxDistanceRackingCars = findMaxDistanceRacingCar(racingCarList)
        outputView.printMaxDistanceRacingCarName(maxDistanceRackingCars)
    }

    private fun addRacingCarDistance(racingCar: RacingCar): RacingCar {
        val randomNum = Randoms.pickNumberInRange(RANDOM_START_NUM, RANDOM_FINISH_NUM)
        if (randomNum >= MIN_DISTANCE_NUM) {
            racingCar.distance += randomNum
        }
        outputView.printRackingCars(racingCar)
        return racingCar
    }

    private fun findMaxDistanceRacingCar(racingCarList: List<RacingCar>): List<String> {
        return racingCarList.filter { racingCar -> racingCar.distance == racingCarList.maxOf { it.distance } }
            .map { it.racingCarName }
    }

    companion object {
        private const val RANDOM_START_NUM = 0
        private const val RANDOM_FINISH_NUM = 9
        const val MIN_DISTANCE_NUM = 4
    }
}