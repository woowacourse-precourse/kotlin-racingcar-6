package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.RacingCars
import racingcar.util.UserInputValidator

class ReadUserInputView {
    private val validator = UserInputValidator()
    fun readCarNames(): RacingCars {
        val carNames = Console.readLine().split(",")
        validateCarNames(carNames)
        return RacingCars(carNames)
    }

    fun readAttemptNumber(): Int {
        val attemptNumberInput = Console.readLine()
        validateAttemptNumber(attemptNumberInput)
        return attemptNumberInput.toInt()
    }

    private fun validateCarNames(carNames: List<String>) {
        validator.validateCarNames(carNames)
    }

    private fun validateAttemptNumber(attemptNumberInput: String) {
        validator.validateNumberFormat(attemptNumberInput)
    }

}