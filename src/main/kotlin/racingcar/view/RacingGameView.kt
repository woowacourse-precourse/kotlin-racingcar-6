package racingcar.view

import racingcar.validator.InputValidator

class RacingGameView {

    private val input = InputView()
    private val output = OutputView()
    private val inputValidator = InputValidator()
    fun inputCarNameList(): List<String> {
        output.printInputGuideCarNameList()
        val carNameList = input.inputCarNameList()
        inputValidator.validateCarNameList(carNameList = carNameList)
        return carNameList
    }

    fun inputPlayCount(): Int {
        output.printInputGuidePlayCount()
        val playCount = input.inputPlayCount()
        inputValidator.validatePlayCount(playCount = playCount)
        return playCount
    }

    fun printResultWinner(winnerList: List<String>) {
        output.printResultWinner(winnerList = winnerList)
    }

    fun printPlayResult(playResult: String) {
        output.printPlayResult(playResult = playResult)
    }
}