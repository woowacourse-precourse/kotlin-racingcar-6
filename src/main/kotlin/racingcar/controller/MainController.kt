package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.model.Cars
import racingcar.util.Util.getRandomNumber
import racingcar.util.Util.isMovable

class MainController(private val inputView: InputView, private val outputView: OutputView) {
    private val cars = Cars()
    private var gameCount = 0

    fun run() {
        gameInit()
        gameStart()
        gameEnd()
    }

    private fun gameStart() {
        repeat(gameCount) {
            playOneCycle()
        }
    }

    private fun gameInit() {
        outputView.printInputCarNameMessage()
        val carNames = inputView.getInputCarNames()
        cars.addAllList(carNames)
        outputView.printInputCountMessage()
        gameCount = inputView.getInputCount()
    }

    private fun playOneCycle() {
        cars.carNames.forEach { car ->
            val isMovable = isMovable(getRandomNumber())
            car.isMove(isMovable)
            outputView.printCarDistance(car)
        }
        println()
    }

    private fun gameEnd() {
        val winners = cars.getWinners()
        outputView.printWinners(winners)
    }
}