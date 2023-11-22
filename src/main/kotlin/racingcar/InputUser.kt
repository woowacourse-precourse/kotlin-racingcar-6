package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.InputUser.GameMessage.DEFAULT_INPUT_MENT

class InputUser {
    fun printlnDefaultMent() {
        println(DEFAULT_INPUT_MENT)
    }

    fun inputCarName(): List<String> {
        val input = Console.readLine()
        return input.split(GameMessage.COMMA).map { it.trim() }
    }

    fun printlnGameCountMent() {
        println(GameMessage.GAME_COUNT_MENT)
    }

    object GameMessage {
        const val DEFAULT_INPUT_MENT: String = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val GAME_COUNT_MENT = "시도할 횟수는 몇 회인가요?"
        const val COMMA = ","
    }
}