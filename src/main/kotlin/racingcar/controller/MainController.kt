package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView
import camp.nextstep.edu.missionutils.Randoms

class MainController(private val inputView: InputView, private val outputView: OutputView) {
    fun getRandomNumber(): Int = Randoms.pickNumberInRange(0, 9)
}