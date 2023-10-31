package racingcar

import camp.nextstep.edu.missionutils.Console

class InputManager {
    private fun inputRacingCarName(): String {
        return Console.readLine()
    }

    private fun inputTrial(): String {
        return Console.readLine()
    }

    fun getRacingCarNameList(): List<String> {
        return inputRacingCarName().split(",")
    }

    fun getTrial(): Int {
        return inputTrial().toInt()
    }
}