package racingcar.ui

import camp.nextstep.edu.missionutils.Console

private const val MSG_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
private const val MSG_INPUT_ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?"

private const val MSG_OUTPUT_RESULT = "실행 결과"
private const val MSG_OUTPUT_WINNER = "최종 우승자 : "

private const val MSG_EXCEPTION_NAME_LENGTH = "이름은 1자 이상 5자 이하만 가능합니다."
private const val MSG_EXCEPTION_ONLY_DIGIT_AND_POSITIVE = "시도 횟수는 1 이상의 숫자만 가능합니다."

object UserInput {

    fun readCarName(): String {
        println(MSG_INPUT_CAR_NAME)
        return Console.readLine()
            .trim()
    }

    fun String.createNameList(): List<String> =
        this.split(',')
            .map { it.trim() }
            .distinct()

    fun readAttemptCount(): String {
        println(MSG_INPUT_ATTEMPT_COUNT)
        return Console.readLine()
            .trim()
    }
}

object UserOutput {

    fun printResultMessage() = println(MSG_OUTPUT_RESULT)

    fun displayRoundResult(name: String, path: String) = print("$name : $path\n")

    fun printWinner(winner: List<String>) =
        println(MSG_OUTPUT_WINNER + winner.joinToString(", "))
}

object InputValidator {
    private const val MIN_NAME_LENGTH = 1
    private const val MAX_NAME_LENGTH = 5

    fun checkNamesLength(names: List<String>) =
        names.forEach { require(it.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { MSG_EXCEPTION_NAME_LENGTH } }

    fun checkOnlyDigit(input: String) {
        require(input.isNotEmpty()) { MSG_EXCEPTION_ONLY_DIGIT_AND_POSITIVE }
        input.forEach { require(it in '0'..'9') { MSG_EXCEPTION_ONLY_DIGIT_AND_POSITIVE } }
    }

    fun isPositive(input: Int) = require(input > 0) { MSG_EXCEPTION_ONLY_DIGIT_AND_POSITIVE }
}