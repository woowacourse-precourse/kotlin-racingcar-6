package controller

import model.CarList
import util.RandNumGenerator
import view.InputView
import view.OutputView

class RacingGame(private val outputView: OutputView, private val inputView: InputView) {
    fun runGame() {
        outputView.outputCarList()
        val carList: CarList = CarList(inputCarList())
        outputView.outputTryNum()
        val tryNum: Int = inputTryNum()
        outputView.outputTryResult()
        repeat(tryNum) {
            tryTurn(carList)
        }
        outputView.outputWinners(carList)
    }

    private fun inputCarList(): String {
        return inputView.inputCarNames()
    }

    private fun inputTryNum(): Int {
        return inputView.inputTryNum().toInt()
    }

    private fun tryTurn(carList: CarList) {
        repeat(carList.carList.size) {
            val speed: Int = RandNumGenerator().getRandNum0to9()
            carList.move(it, speed)
            outputView.outputTurnResult(carList.carList[it])
        }
        outputView.outputBlankLine()
    }
}