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
    }

    fun getRandomNumber(): Int = Randoms.pickNumberInRange(0, 9)
}