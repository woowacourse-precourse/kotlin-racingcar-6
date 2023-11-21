package viewModel

import camp.nextstep.edu.missionutils.Console
import errorMessage.InputError.*
import racingcar.Racing.GameConstants

class ValidInput {
    fun validInputGameCount(): Int {
        val gameCount = Console.readLine()
        if (gameCount.toIntOrNull() == null || gameCount.toInt() <= 0) {
            throw IllegalArgumentException(NOT_DIGIT.message)
        }
        return gameCount.toInt()
    }

    fun validName(carName: List<String>): Boolean {
        if (carName.any { it.length > GameConstants.LIMIT_LENGTH }) {
            throw IllegalArgumentException(OVER_FIVE.message)
        }
        return true
    }
}