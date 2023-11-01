package racingcar.domain

import camp.nextstep.edu.missionutils.Console.readLine

class CarName {
    fun requestInput() {
        println(CarNameConstants.REQUEST_INPUT)
    }

    fun getInput(): String {
        return readLine()
    }

    fun validateInput(input: String): List<String> {
        when {
            input.isEmpty() -> throw IllegalArgumentException(CarNameConstants.INPUT_IS_EMPTY)
            !input.contains(CarNameConstants.COMMA_DELIMITER) -> throw IllegalArgumentException(CarNameConstants.INPUT_ONLY_ONE)
        }

        val splitInput = input.split(CarNameConstants.COMMA_DELIMITER)
        when {
            splitInput.any { it.isEmpty() } -> throw IllegalArgumentException(CarNameConstants.CAR_NAME_HAS_EMPTY)
            splitInput.any { it.isBlank() } -> throw IllegalArgumentException(CarNameConstants.CAR_NAME_HAS_BLANK)
            splitInput.any { it.length > CarNameConstants.CAR_NAME_MAX_LENGTH } -> throw IllegalArgumentException(CarNameConstants.CAR_NAME_HAS_OVER_5_CHARS)
            splitInput.toSet().size != splitInput.size -> throw IllegalArgumentException(CarNameConstants.CAR_NAME_HAS_DUPLICATE)
        }

        return splitInput
    }
}