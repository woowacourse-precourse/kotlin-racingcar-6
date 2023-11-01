package controller

import model.CarList
import view.InputView
import view.OutputView

class RacingGame(private val outputView: OutputView, private val inputView: InputView) {
    fun runGame() {
        outputView.outputCarList()
        val carList: CarList = CarList(inputCarList())
        outputView.outputTryNum()
        val tryNum: Int = inputTryNum()
        outputView.outputTryResult()
    }

    private fun inputCarList(): String {
        return inputView.inputCarNames()
    }

    private fun inputTryNum(): Int {
        return inputView.inputTryNum().toInt()
    }
}