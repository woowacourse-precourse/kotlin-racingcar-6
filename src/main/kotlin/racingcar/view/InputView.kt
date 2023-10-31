package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    companion object {
        private const val ERROR_EMPTY_NAME_LIST = "이름을 입력해야합니다."
        private const val ERROR_EXCEED_FIVE_LETTERS = "이름은 5글자 이하만 가능합니다."
        private const val ERROR_NAME_IS_NULL = "입력되지 않은 이름이 있습니다."
        private const val ERROR_NAME_NOT_LETTER = "글자로 된 이름만 입력 가능합니다."

        private const val ERROR_ROUND_NUM_UNDER_ONE = "시도 횟수는 1보다 커야합니다."
        private const val ERROR_ROUND_NUM_UNDEFINED = "시도 횟수는 숫자이면서, Int 범위 이내여야 합니다."
    }

    fun inputCarName(): List<String> {
        val carNameList = Console.readLine().split(",")
        return checkCarNameList(carNameList)
    }

    fun checkCarNameList(carNameList: List<String>): List<String> {
        require(carNameList.isNotEmpty()) { ERROR_EMPTY_NAME_LIST }
        for (carName in carNameList) {
            require (carName.length <= 5) { ERROR_EXCEED_FIVE_LETTERS }
            require (carName.isNotEmpty()) { ERROR_NAME_IS_NULL }
            require(carName.all { it.isLetter() }) { ERROR_NAME_NOT_LETTER }
        }
        return carNameList
    }

    fun inputRoundNumber(): Int {
        val roundNumber = Console.readLine()
        return checkRoundNumber(roundNumber)
    }

    fun checkRoundNumber(roundNumber: String): Int {
        try {
            val validRoundNumber = roundNumber.toInt()
            require(validRoundNumber >= 1) { ERROR_ROUND_NUM_UNDER_ONE }
            return validRoundNumber
        } catch (exception: NumberFormatException) {
            throw IllegalArgumentException(ERROR_ROUND_NUM_UNDEFINED)
        }
    }

    fun closeConsole() {
        Console.close()
    }
}