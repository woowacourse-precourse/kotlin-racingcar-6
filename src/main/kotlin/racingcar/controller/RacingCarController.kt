package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.RacingCar
import racingcar.view.InputView

class RacingCarController {

    private val inputView = InputView()
    fun playGame() {
        inputView.printInputCarName()
        val userList = Console.readLine().split(",")
        val racingCarList = userList.map { RacingCar(it, 0) }
        inputView.printInputGameCount()
        val gameCount = Console.readLine().toInt()
        gameContinue(racingCarList, gameCount)
    }

    private fun gameContinue(racingCarList: List<RacingCar>, gameCount: Int) {
        for (i in 0 until gameCount) {
            racingCarList.map {
                it.distance += Randoms.pickNumberInRange(0, 9)
            }
        }

    }
}