package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    companion object {
        private const val INPUT_ERROR_MESSAGE = "제대로 입력하세요."
        private const val TO_INT_ERROR_MESSAGE = "숫자를 입력하세요"
        private const val NOT_POSITIVE_INT_MESSAGE = "양수가 아닙니다."
    }

    fun inputCarNameList(): List<String> {
        return inputUserForWait().split(',')
    }

    fun inputPlayCount(): Int {
        val playCount = inputUserForWait().toIntOrNull() ?: throw IllegalArgumentException(TO_INT_ERROR_MESSAGE)
        require(playCount > 0) { NOT_POSITIVE_INT_MESSAGE }
        return playCount
    }

    private fun inputUserForWait(): String {
        return Console.readLine() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
    }
}