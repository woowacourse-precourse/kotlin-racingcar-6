package racingcar

import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val outputView = OutputView()
    val inputView = InputView()
    outputView.printInputCarNameMessage()
    val userInput = inputView.getUserInput()
}
