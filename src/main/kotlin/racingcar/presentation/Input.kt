package racingcar.presentation

import camp.nextstep.edu.missionutils.Console
import racingcar.util.InputValidator
import kotlin.IllegalArgumentException

object Input {

    private const val SEPARATOR = ","
    private const val INPUT_MESSAGE_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val INPUT_MESSAGE_COUNTS = "시도할 횟수는 몇 회인가요?"

    fun getPlayerList(): List<String> {
        println(INPUT_MESSAGE_NAMES)
        val input = Console.readLine()
        val users = separateUsers(input)
        return when (val result = InputValidator.validateUserName(users)) {
            InputValidator.UserNameValidation.OVER_LENGTH,
            InputValidator.UserNameValidation.LEAST_ONE -> throw IllegalArgumentException(result.message)

            InputValidator.UserNameValidation.VALID -> users
        }
    }

    private fun separateUsers(users: String): List<String> =
        users.split(SEPARATOR).map { it.trim() }.filter { it.isNotEmpty() }

    fun getGameCount(): Int {
        println(INPUT_MESSAGE_COUNTS)
        val input = Console.readLine()
        return when (val result = InputValidator.validateGameCount(input)) {
            InputValidator.GameCountValidation.OUT_RANGE,
            InputValidator.GameCountValidation.NOT_INTEGER -> throw IllegalArgumentException(result.message)

            InputValidator.GameCountValidation.VALID -> input.toInt()
        }
    }

    fun close() {
        Console.close()
    }
}