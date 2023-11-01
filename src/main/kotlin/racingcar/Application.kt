package racingcar

import racingcar.controller.Controller
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    Controller(InputView(), OutputView()).startGame()
}
