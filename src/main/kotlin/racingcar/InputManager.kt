package racingcar

import camp.nextstep.edu.missionutils.Console

class InputManager {
    fun getCarNameFromUser(): String {
        println(CAR_NAMES_INPUT_PROMPT_MESSAGE)
        return Console.readLine()
    }

    fun getRaceRoundFromUser(): String {
        println(RACE_ROUND_INPUT_PROMPT_MESSAGE)
        return Console.readLine()
    }

    companion object {
        private const val CAR_NAMES_INPUT_PROMPT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val RACE_ROUND_INPUT_PROMPT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}