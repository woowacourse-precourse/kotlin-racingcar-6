package racingcar.view

import racingcar.domain.Constants
import camp.nextstep.edu.missionutils.Console
import racingcar.domain.car.CarNames

object InputView {
    fun readNames(): CarNames {
        OutputView.startReadNames()
        val input = Console.readLine()?.trim() ?: throw IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE)
        if (input.isBlank()) {
            throw IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE)
        }
        val carNames = input.split(Constants.COMMA)

        if (carNames.distinct().size != carNames.size) {
            throw IllegalArgumentException(Constants.DISTINCT_ERROR_MESSAGE)
        }

        return CarNames(carNames)
    }

    fun readCount(): Int {
        OutputView.startReadCount()
        val input = Console.readLine()?.trim() ?: throw IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE)
        if (input.isBlank()) {
            throw IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE)
        }
        return try {
            val count = input.toInt()
            if (count < 0) {
                throw IllegalArgumentException(Constants.NEGATIVE_NUMBER_ERROR_MESSAGE)
            }
            count
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(Constants.NOT_NUMBER_ERROR_MESSAGE)
        }
    }
}
