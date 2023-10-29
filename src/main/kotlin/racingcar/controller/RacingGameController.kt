package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.view.RacingGameView
import racingcar.model.RacingGameModel

class RacingGameController(private val view: RacingGameView, private val model: RacingGameModel) {
    fun run() {
        view.requestCarNameInput()
        getCarList()
    }
    private fun getCarList() {
        val carList: List<String> = listOf(*Console.readLine().split(",").toTypedArray())
    }
}