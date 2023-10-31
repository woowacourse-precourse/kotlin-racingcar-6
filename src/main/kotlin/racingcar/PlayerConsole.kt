package racingcar

import camp.nextstep.edu.missionutils.Console.readLine
import racingcar.Constants.MESSAGE_INVALID_NAME_FORMAT
import racingcar.Constants.MESSAGE_INVALID_NAME_LENGTH
import racingcar.Constants.MESSAGE_INVALID_NUMBER_FORMAT
import racingcar.Constants.MESSAGE_INVALID_NUMBER_RANGE
import racingcar.Constants.MINIMUM_CAR_NAME_LENGTH
import racingcar.Constants.MINIMUM_MOVE_COUNT

object PlayerConsole {

    fun getValidCarNames() = parseInputByComma().validateCarNames()

    private fun parseInputByComma() = readLine().split(",")

    private fun List<String>.validateCarNames(): List<String> {
        require(this.all { it.length <= MINIMUM_CAR_NAME_LENGTH && it.isNotEmpty() }) { MESSAGE_INVALID_NAME_LENGTH }
        require(this.all { playerName -> playerName.all { it.isLetter() || it.isDigit() } }) { MESSAGE_INVALID_NAME_FORMAT }
        return this
    }

    fun getValidMoveCount() = readLine().toNumberOrException()

    private fun String.toNumberOrException(): Int {
        require(this.all { it.isDigit() }) { MESSAGE_INVALID_NUMBER_FORMAT }
        require(MINIMUM_MOVE_COUNT <= this.toInt()) { MESSAGE_INVALID_NUMBER_RANGE }
        return this.toInt()
    }
}