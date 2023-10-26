package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.constant.ErrorMessage
import racingcar.domain.RacingCars
import racingcar.util.AttemptCountValidator
import racingcar.util.CarNameValidator

class ReadUserInputView {
    private val attemptNumberValidator = AttemptCountValidator()
    private val carNamesValidator = CarNameValidator()
    fun readCarNames(): RacingCars {
        val carNames = Console.readLine().split(",")
        validateNameLength(carNames)
        return RacingCars(carNames)
    }

    fun readAttemptNumber(): Int {
        val attemptNumberInput = Console.readLine()
        validateAttemptNumber(attemptNumberInput)
        return attemptNumberInput.toInt()
    }

    private fun validateNameLength(carNames: List<String>) {
        carNamesValidator.validateCarNamesLength(carNames)
    }

    private fun validateAttemptNumber(attemptNumberInput: String) {
        attemptNumberValidator.validateNumberFormat(attemptNumberInput)
    }
    
}