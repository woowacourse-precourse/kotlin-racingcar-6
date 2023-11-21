package viewModel

import camp.nextstep.edu.missionutils.Console
import errorMessage.InputError.*
import racingcar.Racing.GameConstants

class ValidInput {
    fun validInputGameCount(): Int {
        val gameCount = Console.readLine()
        require(gameCount.toIntOrNull() != null && gameCount.toInt() > 0) { NOT_DIGIT.message }
        return gameCount.toInt()
    }

    fun validName(carName: List<String>) {
        require(!carName.any { it.length > GameConstants.LIMIT_LENGTH }) { OVER_FIVE.message }
    }
}
