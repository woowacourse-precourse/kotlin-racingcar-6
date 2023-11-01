package racingcar.view

import camp.nextstep.edu.missionutils.Console.readLine
import racingcar.view.GameConsole.printCarNamePrompt
import racingcar.view.GameConsole.printMoveCountPrompt

object PlayerConsole {

    private const val MESSAGE_INVALID_NAME_LENGTH = "자동차 이름은 한 글자 이상, 5글자 이하로 입력해 주세요."
    private const val MESSAGE_INVALID_NAME_FORMAT = "문자와 숫자만 입력해 주세요."
    private const val MESSAGE_INVALID_NUMBER_FORMAT = "숫자만 입력해 주세요."
    private const val MESSAGE_INVALID_NUMBER_RANGE = "입력 숫자의 범위가 유효하지 않습니다."
    private const val MINIMUM_MOVE_COUNT = 1
    private const val MINIMUM_CAR_NAME_LENGTH = 1
    private const val MAXIMUM_CAR_NAME_LENGTH = 5

    fun getValidCarNames(): List<String> {
        printCarNamePrompt()
        return parseInputByComma().validateCarNames()
    }

    private fun parseInputByComma() = readLine().split(",")

    private fun List<String>.validateCarNames(): List<String> {
        require(this.all { it.length in MINIMUM_CAR_NAME_LENGTH..MAXIMUM_CAR_NAME_LENGTH }) { MESSAGE_INVALID_NAME_LENGTH }
        require(this.all { playerName -> playerName.all { it.isLetter() || it.isDigit() } }) { MESSAGE_INVALID_NAME_FORMAT }
        return this
    }

    fun getValidMoveCount(): Int {
        printMoveCountPrompt()
        return readLine().toIntegerOrException()
    }

    private fun String.toIntegerOrException(): Int {
        require(this.all { it.isDigit() }) { MESSAGE_INVALID_NUMBER_FORMAT }
        require(this.toLong() in MINIMUM_MOVE_COUNT..Int.MAX_VALUE) { MESSAGE_INVALID_NUMBER_RANGE }
        return this.toInt()
    }
}