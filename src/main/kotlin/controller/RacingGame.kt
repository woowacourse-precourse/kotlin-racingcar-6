package controller

import model.CarList
import view.InputView
import view.OutputView

class RacingGame(private val outputView: OutputView, private val inputView: InputView) {
    fun runGame() {
        outputView.outputCarList()
        val carList: CarList = CarList(inputCarList())
    }

    private fun inputCarList(): String {
        var input = inputView.inputCarNames()
        return input
    }
}