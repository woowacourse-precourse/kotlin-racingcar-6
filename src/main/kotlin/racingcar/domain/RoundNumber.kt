package racingcar.domain

import camp.nextstep.edu.missionutils.Console

class RoundNumber {
    fun requestInput() {
        println(RoundNumberConstants.REQUEST_INPUT)
    }

    fun getInput(): String {
        return Console.readLine()
    }

    fun validateInput(input: String): Int {
        if (input.isEmpty()) {
            throw IllegalArgumentException(RoundNumberConstants.INPUT_IS_EMPTY)
        }

        val inputInt = input.toIntOrNull() ?: throw IllegalArgumentException(RoundNumberConstants.INPUT_IS_NOT_INT)

        if (inputInt < RoundNumberConstants.POSITIVE_NUMBER_ONE) {
            throw IllegalArgumentException(RoundNumberConstants.ROUND_NUMBER_IS_NOT_POSITIVE)
        }

        return inputInt
    }
}