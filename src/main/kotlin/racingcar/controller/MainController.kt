package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView
import camp.nextstep.edu.missionutils.Randoms
import model.Cars

class MainController(private val inputView: InputView, private val outputView: OutputView) {
    private val cars = Cars()
    fun gameStart() {
        outputView.printInputCarNameMessage()
        val carNames = inputView.getInputCarNames()
        cars.addAllList(carNames)
        outputView.printInputCountMessage()
        val gameCnt = inputView.getInputCount()

        repeat(gameCnt) {
            cars.carNames.forEach { car ->
                val isMovable = isMovable(getRandomNumber())
                car.isMove(isMovable)
                outputView.printCarDistance(car)
            }
            println()
        }
    }

    fun getRandomNumber(): Int = Randoms.pickNumberInRange(0, 9)

    fun isMovable(number: Int): Boolean = number >= 4
}