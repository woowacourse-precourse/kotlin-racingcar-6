package racingcar.domain

import camp.nextstep.edu.missionutils.Console
import racingcar.RoundNumberConstants

class RoundNumber {
    fun requestInput() {
        println(RoundNumberConstants.REQUEST_INPUT)
    }

    fun getInput(): String {
        return Console.readLine()
    }

    fun validateInput(input: String) {
        if (input.isEmpty()) {
            throw IllegalArgumentException(RoundNumberConstants.INPUT_IS_EMPTY)
        }

        val inputInt = input.toIntOrNull()

        if (inputInt == null) {
            throw IllegalArgumentException(RoundNumberConstants.INPUT_IS_NOT_INT)
        }

        if (inputInt < RoundNumberConstants.POSITIVE_NUMBER_ONE) {
            throw IllegalArgumentException(RoundNumberConstants.ROUND_NUMBER_IS_NOT_POSITIVE)
        }

    }
}