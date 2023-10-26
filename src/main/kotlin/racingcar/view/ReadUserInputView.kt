package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.AttemptCountValidator

class ReadUserInputView {
    private val validator = AttemptCountValidator()
    fun readCarNames(): List<String> {
        return Console.readLine().split(",")
    }

    fun readAttemptNumber(): Int {
        val attemptNumberInput = Console.readLine()
        validateAttemptNumber(attemptNumberInput)
        return attemptNumberInput.toInt()
    }

    private fun validateAttemptNumber(attemptNumberInput: String) {
        validator.isNumberFormat(attemptNumberInput)
    }
}