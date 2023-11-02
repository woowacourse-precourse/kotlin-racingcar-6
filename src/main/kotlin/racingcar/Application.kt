package racingcar

import racingcar.controller.MainController
import racingcar.util.Util.separateNameByComma
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val outputView = OutputView()
    val inputView = InputView()
    val controller = MainController(inputView, outputView)
    controller.gameStart()
}
