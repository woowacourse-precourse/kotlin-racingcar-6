package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getInputCarName(): List<String> {
        printInputCarName()
        val users = Console.readLine().split(NAME_DELIMITERS)
        checkRacingCarNameSize(users)
        return users
    }

    private fun printInputCarName() = println(INPUT_CAR_NAME_MESSAGE)

    fun getInputGameCount(): Int {
        printInputGameCount()
        val gameCount = Console.readLine()
        return checkNumber(gameCount)
    }

    private fun printInputGameCount() = println(INPUT_GAME_COUNT_MESSAGE)

    fun checkRacingCarNameSize(users: List<String>) {
        users.forEach {
            require(it.length <= MAX_NAME_LENGTH_NUM)
        }
    }

    fun checkNumber(input: String): Int {
        val gameCount = input.toIntOrNull() ?: 0
        require(gameCount > 0)
        return gameCount
    }

    companion object {
        private const val NAME_DELIMITERS = ","
        private const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val INPUT_GAME_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"

        const val MAX_NAME_LENGTH_NUM = 5
    }
}