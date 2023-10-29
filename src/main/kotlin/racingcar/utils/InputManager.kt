package racingcar.utils

import camp.nextstep.edu.missionutils.Console

class InputManager {
    fun getCarNameFromUser(): String {
        println(Constants.CAR_NAMES_INPUT_PROMPT_MESSAGE)
        return Console.readLine()
    }

    fun getMoveCountFromUser(): String {
        println(Constants.MOVE_COUNT_INPUT_PROMPT_MESSAGE)
        return Console.readLine()
    }
}