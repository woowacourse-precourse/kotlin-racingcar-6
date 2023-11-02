package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView
import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Cars
import racingcar.util.Constants.END_NUMBER
import racingcar.util.Constants.MOVABLE_NUMBER
import racingcar.util.Constants.START_NUMBER

class MainController(private val inputView: InputView, private val outputView: OutputView) {
    private val cars = Cars()
    private var gameCount = 0

    fun run() {
        gameInit()
        gameStart()
        gameEnd()
    }

    fun gameStart() {
        repeat(gameCount) {
            playOneCycle()
        }
    }

    fun gameInit() {
        outputView.printInputCarNameMessage()
        val carNames = inputView.getInputCarNames()
        cars.addAllList(carNames)
        outputView.printInputCountMessage()
        gameCount = inputView.getInputCount()
    }

    fun playOneCycle() {
        cars.carNames.forEach { car ->
            val isMovable = isMovable(getRandomNumber())
            car.isMove(isMovable)
            outputView.printCarDistance(car)
        }
        println()
    }

    fun gameEnd() {
        val winners = cars.getWinners()
        outputView.printWinners(winners)
    }

    fun getRandomNumber(): Int = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER)

    fun isMovable(number: Int): Boolean = number >= MOVABLE_NUMBER
}