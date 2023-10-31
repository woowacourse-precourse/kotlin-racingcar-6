package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {

    private val inputView = InputView()
    private val outputView = OutputView()

    fun playGame() {
        var racingCarList = inputView.printInputCarName()
        val gameCount = inputView.printInputGameCount()
        racingCarList = gameContinue(racingCarList, gameCount)
        gameResult(racingCarList)
    }

    private fun gameContinue(racingCarList: List<RacingCar>, gameCount: Int): List<RacingCar> {
        outputView.printResult()

        for (i in 0 until gameCount) {
            racingCarList.forEach {
                addRacingCarDistance(it)
            }
            outputView.printEnter()
        }

        return racingCarList
    }

    private fun gameResult(racingCarList: List<RacingCar>) {
        val maxDistanceRacingCarList = findMaxDistanceRacingCar(racingCarList)
        outputView.printMaxDistanceRacingCarName(maxDistanceRacingCarList)
    }

    private fun addRacingCarDistance(racingCar: RacingCar): RacingCar {
        val randomNum = Randoms.pickNumberInRange(RANDOM_START_NUM, RANDOM_FINISH_NUM)
        if (randomNum >= MIN_DISTANCE_NUM) {
            racingCar.distance += randomNum
        }
        outputView.printRacingCarList(racingCar)
        return racingCar
    }

    private fun findMaxDistanceRacingCar(racingCarList: List<RacingCar>): List<String> {
        return racingCarList.filter { racingCar -> racingCar.distance == racingCarList.maxOf { it.distance } }
            .map { it.racingCarName }
    }

    companion object {
        const val RANDOM_START_NUM = 0
        const val RANDOM_FINISH_NUM = 9
        const val MIN_DISTANCE_NUM = 4
        const val MAX_NAME_LENGTH_NUM = 5
    }
}