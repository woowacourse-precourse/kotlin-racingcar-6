package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.Converter.convertStringToMap
import racingcar.ErrorMessage.CAR_MINIMUM_COUNT_ERROR
import racingcar.ErrorMessage.CAR_NAME_LENGTH_OVER_ERROR
import racingcar.ErrorMessage.DUPLICATE_CAR_NAME_ERROR
import racingcar.GameMessage.INPUT_RACING_CAR_NAME_MESSAGE
import racingcar.UserInput.getUserInput

object RacingCarInput {
    private const val MIN_CAR_COUNT = 1
    private const val MAX_CAR_NAME_LENGTH = 5

    fun getCarNameMap(): Map<String, Int> {
        println(INPUT_RACING_CAR_NAME_MESSAGE)
        val userInput = getUserInput()
        return runCatching {
            convertStringToMap(userInput).apply { validate(this) }
        }.getOrElse { throwable ->
            throw IllegalArgumentException(throwable)
        }
    }

    private fun validate(carNameMap: Map<String, Int>) {
        validateCarNameDuplicate(carNameMap)
        validateMinimumCarCount(carNameMap)
        validateCarNameLength(carNameMap)
    }

    private fun validateCarNameDuplicate(carNameMap: Map<String, Int>) {
        val carNames = carNameMap.keys
        if (carNames.size != carNames.distinct().size) {
            throw IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR)
        }
    }

    private fun validateMinimumCarCount(carNameMap: Map<String, Int>) {
        if (carNameMap.size <= MIN_CAR_COUNT) {
            throw IllegalArgumentException(CAR_MINIMUM_COUNT_ERROR)
        }
    }

    private fun validateCarNameLength(carNameMap: Map<String, Int>) {
        for (carName in carNameMap.keys) {
            validateLength(carName)
        }
    }

    private fun validateLength(carName: String) {
        if (carName.length > MAX_CAR_NAME_LENGTH) {
            throw IllegalArgumentException(CAR_NAME_LENGTH_OVER_ERROR)
        }
    }
}
