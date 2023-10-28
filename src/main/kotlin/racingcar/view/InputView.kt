package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    companion object {
        private const val INPUT_ERROR_MESSAGE = "제대로 입력하세요."
        private const val TO_INT_ERROR_MESSAGE = "숫자를 입력하세요"
    }

    fun inputCarNameList(): List<String> = inputUserForWait().split(',')
    fun inputPlayCount(): Int = inputUserForWait().toIntOrNull() ?: throw IllegalArgumentException(TO_INT_ERROR_MESSAGE)
    private fun inputUserForWait(): String = Console.readLine() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
}