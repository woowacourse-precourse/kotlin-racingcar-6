package view

import camp.nextstep.edu.missionutils.Console.readLine

object PlayerConsole {

    private const val MESSAGE_INVALID_NAME_LENGTH = "자동차 이름은 한 글자 이상, 5글자 이하로 입력해 주세요."
    private const val MESSAGE_INVALID_NAME_FORMAT = "문자와 숫자만 입력해 주세요."
    private const val MESSAGE_INVALID_NUMBER_FORMAT = "숫자만 입력해 주세요."
    private const val MESSAGE_INVALID_NUMBER_RANGE = "1 이상의 시도 횟수를 입력해주세요."
    private const val MINIMUM_MOVE_COUNT = 1
    private const val MINIMUM_CAR_NAME_LENGTH = 5

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