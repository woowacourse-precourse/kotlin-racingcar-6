package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.view.InputView

class RacingCarController(private val inputView: InputView) {
    fun racingRun() {
        inputView.inputCarNamesMessage()
        inputCarName()
    }
    private fun inputCarName() {
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


}