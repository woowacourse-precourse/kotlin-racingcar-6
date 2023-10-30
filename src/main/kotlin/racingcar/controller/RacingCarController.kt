package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar
import racingcar.view.InputView

class RacingCarController {

    private val inputView = InputView()
    fun playGame() {
        inputView.printInputCarName()
        val userList = Console.readLine().split(NAME_DELIMITERS)
        val racingCarList = userList.map { RacingCar(it, INIT_DISTANCE_NUM) }
        inputView.printInputGameCount()
        val gameCount = Console.readLine().toInt()
        gameContinue(racingCarList, gameCount)
    }

    private fun gameContinue(racingCarList: List<RacingCar>, gameCount: Int) {

        for (i in 0 until gameCount) {
            racingCarList.map {
                val randomNum = Randoms.pickNumberInRange(RANDOM_START_NUM, RANDOM_FINISH_NUM)
                if (randomNum >= MIN_DISTANCE_NUM) {
                    it.distance += randomNum
                }
            }

        }
    }

    companion object {
        const val RANDOM_START_NUM = 0
        const val RANDOM_FINISH_NUM = 9
        const val MIN_DISTANCE_NUM = 4
        const val NAME_DELIMITERS = ","
        const val INIT_DISTANCE_NUM = 0
    }
}