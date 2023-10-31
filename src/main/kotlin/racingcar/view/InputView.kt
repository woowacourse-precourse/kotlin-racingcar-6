package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    enum class ErrorMessages(val text: String) {
        INPUT_ERROR("제대로 입력하세요."),
        TO_INT_ERROR("숫자를 입력하세요")
    }

    fun inputCarNameList(): List<String> = inputUserForWait().split(',')
    fun inputPlayCount(): Int =
        inputUserForWait().toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.TO_INT_ERROR.text)

    private fun inputUserForWait(): String =
        Console.readLine() ?: throw IllegalArgumentException(ErrorMessages.INPUT_ERROR.text)
}