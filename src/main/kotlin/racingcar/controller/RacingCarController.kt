package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.view.InputView

class RacingCarController(private val inputView: InputView) {
    fun racingRun() {
        inputCarName()
        inputTryRaceCount()
    }
    private fun inputCarName() {
        inputView.inputCarNamesMessage()
        val inputName = Console.readLine()
        splitInputName(inputName.trim())
    }

    private fun splitInputName(inputName: String): String {
        val splitInputName = inputName.split(",")
        validateInputName(splitInputName)
        return inputName
    }

    private fun validateInputName(splitInputName: List<String>) {
        splitInputName.map{ names ->
            if(names.length > 5) throw IllegalArgumentException("5글자가 넘는 자동차 이름이 있습니다.")
        }
    }

    private fun inputTryRaceCount() {
        var tryCount:Int = 0
        inputView.inputTryRaceCountMessage()
        try {
            tryCount = Console.readLine().toInt()
        }catch (e:NumberFormatException){
            throw IllegalArgumentException("숫자가 아닌 다른 값이 입력되었습니다.")
        }
        validateInputTryRace(tryCount)
    }

    private fun validateInputTryRace(tryCount: Int) {
        if(tryCount == 0)
            throw IllegalArgumentException("0은 입력될 수 없습니다.")
    }
}