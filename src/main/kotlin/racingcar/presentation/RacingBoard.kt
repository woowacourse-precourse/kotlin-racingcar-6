package racingcar.presentation

import camp.nextstep.edu.missionutils.Console
import racingcar.util.InputValidator
import racingcar.util.InputValidator.UserNameValidation.*
import kotlin.IllegalArgumentException

class RacingBoard {

    fun getPlayerList(): List<String> {
        println(INPUT_MESSAGE_NAMES)
        val input = Console.readLine()
        val users = separateUsers(input)
        return when (val result = InputValidator.validateUserName(users)) {
            OVER_LENGTH,
            LEAST_ONE -> throw IllegalArgumentException(result.message)

            VALID -> users
        }
    }

    private fun separateUsers(users: String): List<String> = users.split(SEPARATOR).map { it.trim() }

    companion object {
        private const val SEPARATOR = ","
        private const val INPUT_MESSAGE_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    }
}