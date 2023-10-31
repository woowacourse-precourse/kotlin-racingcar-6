package racingcar.domain

import camp.nextstep.edu.missionutils.Console.readLine
import racingcar.CarNameConstants

class CarName {
    fun requestInput() {
        println(CarNameConstants.REQUEST_INPUT)
    }

    fun getInput(): String {
        return readLine()
    }

    fun validateInput(input: String): List<String> {
        if (input.isEmpty()) {
            throw IllegalArgumentException(CarNameConstants.INPUT_IS_EMPTY)
        }

        if (!input.contains(CarNameConstants.COMMA_DELIMITER)) {
            throw IllegalArgumentException(CarNameConstants.INPUT_ONLY_ONE)
        }

        val splitInput = input.split(CarNameConstants.COMMA_DELIMITER)

        if (splitInput.any { it.isEmpty() }) {
            throw IllegalArgumentException(CarNameConstants.CAR_NAME_HAS_EMPTY)
        }

        if (splitInput.any { it.isBlank() }) {
            throw IllegalArgumentException(CarNameConstants.CAR_NAME_HAS_BLANK)
        }

        if (splitInput.any { it.length > 5 }) {
            throw IllegalArgumentException(CarNameConstants.CAR_NAME_HAS_OVER_5_CHARS)
        }

        if (splitInput.toSet().size != splitInput.size) {
            throw IllegalArgumentException(CarNameConstants.CAR_NAME_HAS_DUPLICATE)
        }

        return splitInput
    }
}