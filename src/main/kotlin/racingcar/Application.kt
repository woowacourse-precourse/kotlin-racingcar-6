package racingcar

import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    inputView.playGame()
    outputView.gameResult()
}
