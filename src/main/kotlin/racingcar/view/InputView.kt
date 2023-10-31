package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    companion object {
        private const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }

    private fun inputCarNamesMessage() {
        println(INPUT_CAR_NAMES_MESSAGE)
    }

    fun inputCarNames(): List<String> {
        inputCarNamesMessage()
        val inputName = Console.readLine()
        validateNotFindComma(inputName)
        return splitInputNames(inputName.trim())
    }

    fun splitInputNames(inputName: String): List<String> {
        val splitString = inputName.split(",")
        validateOverFiveName(splitString)
        validateDuplicateCheck(splitString)
        return splitString
    }

    private fun validateOverFiveName(splitString: List<String>) {
        splitString.map { names ->
            if (names.length > 5) throw IllegalArgumentException("5글자가 넘는 자동차 이름이 있습니다.")
        }
    }

    private fun validateDuplicateCheck(splitInputName: List<String>) {
        for (x in splitInputName) {
            require(splitInputName.count { it == x } <= 1) { "중복된 자동차 이름이 있습니다." } // 같은 수가 1개 이상인 경우
        }
    }

    private fun validateNotFindComma(inputName: String) {
        if (!inputName.contains(",")) {
            throw IllegalArgumentException("입력값에 쉼표가 포함되지 않았습니다.")
        }
    }

    private fun inputTryRaceCountMessage() {
        println(INPUT_TRY_COUNT_MESSAGE)
    }

    fun inputTryRaceCount(): Int {
        val tryCount: Int
        inputTryRaceCountMessage()
        try {
            tryCount = Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자가 아닌 다른 값이 입력 되었습니다.")
        }
        validateNotTryZero(tryCount)

        return tryCount
    }

    private fun validateNotTryZero(tryCount: Int) {
        if (tryCount == 0) throw IllegalArgumentException("0은 입력될 수 없습니다.")
    }

}