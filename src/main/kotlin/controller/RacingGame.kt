package controller

import view.InputView
import view.OutputView

class RacingGame(private val outputView: OutputView, private val inputView: InputView) {
    fun runGame() {
        outputView.outputCarNames()
    }
}