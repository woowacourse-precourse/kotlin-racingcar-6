package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.constant.ErrorMessage
import racingcar.domain.RacingCars
import racingcar.util.AttemptCountValidator

class ReadUserInputView {
    private val validator = AttemptCountValidator()
    fun readCarNames(): RacingCars {
        val carNames = Console.readLine().split(",")
        require(validateNameLength(carNames)) { ErrorMessage.NAME_LENGTH_GREATER_THAN_FIVE }
        return RacingCars(carNames)
    }

    fun readAttemptNumber(): Int {
        val attemptNumberInput = Console.readLine()
        validateAttemptNumber(attemptNumberInput)
        return attemptNumberInput.toInt()
    }

    private fun validateNameLength(carNames: List<String>): Boolean {
        return carNames.none{ it.length > 5}
    }

    private fun validateAttemptNumber(attemptNumberInput: String) {
        validator.isNumberFormat(attemptNumberInput)
    }
}