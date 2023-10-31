package racingcar

import camp.nextstep.edu.missionutils.Console
import utils.Constants.CAR_NAME_INPUT_MSG
import utils.Constants.ROUND_INPUT_MSG

class UserInputReader {
    
    fun getCarName(): List<String> {
        println(CAR_NAME_INPUT_MSG)
        val input = Console.readLine()
        return setCarNameList(input)
    }

    fun setCarNameList(input: String): List<String> {
        return input.split(",")
    }

    fun getRoundCount(): Int {
        println(ROUND_INPUT_MSG)
        val input = Console.readLine()
        return input.toInt()
    }
}