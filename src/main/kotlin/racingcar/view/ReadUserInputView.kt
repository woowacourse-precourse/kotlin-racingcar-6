package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.RacingCars
import racingcar.util.AttemptCountValidator

class ReadUserInputView {
    private val attemptNumberValidator = AttemptCountValidator()
    fun readCarNames(): RacingCars = RacingCars(Console.readLine().split(","))

    fun readAttemptNumber(): Int {
        val attemptNumberInput = Console.readLine()
        validateAttemptNumber(attemptNumberInput)
        return attemptNumberInput.toInt()
    }

    private fun validateAttemptNumber(attemptNumberInput: String) {
        attemptNumberValidator.validateNumberFormat(attemptNumberInput)
    }

}