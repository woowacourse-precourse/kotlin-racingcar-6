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
        inputView.printInputCarName()
        val userList = Console.readLine().split(NAME_DELIMITERS)
        var racingCarList = userList.map { RacingCar(it, INIT_DISTANCE_NUM) }
        inputView.printInputGameCount()
        val gameCount = Console.readLine().toInt()
        racingCarList = gameContinue(racingCarList, gameCount)
        gameResult(racingCarList)
    }

    private fun gameContinue(racingCarList: List<RacingCar>, gameCount: Int): List<RacingCar> {

        outputView.printResult()

        for (i in 0 until gameCount) {
            racingCarList.map {
                val randomNum = Randoms.pickNumberInRange(RANDOM_START_NUM, RANDOM_FINISH_NUM)
                if (randomNum >= MIN_DISTANCE_NUM) {
                    it.distance += randomNum
                }
                outputView.printRacingCarList(it)
            }
            outputView.printEnter()
        }
        return racingCarList
    }

    private fun gameResult(racingCarList: List<RacingCar>) {
        val maxDistanceRacingCarList = findMaxDistanceRacingCar(racingCarList)
    }

    private fun findMaxDistanceRacingCar(racingCarList: List<RacingCar>): List<String> {
        return racingCarList.filter { racingCar -> racingCar.distance == racingCarList.maxOf { it.distance } }
            .map { it.racingCarName }
    }

    companion object {
        const val RANDOM_START_NUM = 0
        const val RANDOM_FINISH_NUM = 9
        const val MIN_DISTANCE_NUM = 4
        const val NAME_DELIMITERS = ","
        const val INIT_DISTANCE_NUM = 0
    }
}