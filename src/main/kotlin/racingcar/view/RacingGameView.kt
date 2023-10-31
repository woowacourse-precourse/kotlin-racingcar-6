package racingcar.view

import racingcar.model.Car
import racingcar.validator.InputValidator

class RacingGameView {
    private val input = InputView()
    private val output = OutputView()
    private val inputValidator = InputValidator()
    fun inputCarNameList(): List<Car> {
        output.printInputGuideCarNameList()
        val carNameList = input.inputCarNameList()
        inputValidator.validateCarNameList(carNameList = carNameList)
        return carNameList.map { carName -> Car(name = carName) }
    }

    fun inputPlayCount(): Int {
        output.printInputGuidePlayCount()
        val playCount = input.inputPlayCount()
        inputValidator.validatePlayCount(playCount = playCount)
        output.printMessage("") // 예시와 동일하게 출력되기 위해 작성
        return playCount
    }

    fun printResultWinner(winnerList: List<Car>) {
        output.printResultWinner(winnerList = winnerList.map { car: Car -> car.name })
    }

    fun printResultMessage() = output.printResultMessage()
    fun printPlayStatus(playStatus: String) = output.printPlayStatus(playStatus = playStatus + "\n")
}