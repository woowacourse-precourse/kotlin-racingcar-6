package domain

import camp.nextstep.edu.missionutils.Console
import domain.Constant.NAME_DIVISION_NOTATION

class Input {
    val exception = Exception()
    fun inputName(): List<String> {
        val inputCarName = Console.readLine()
        exception.wrongNameException(inputCarName)
        exception.nameLengthException(inputCarName)
        exception.nameNotationException(inputCarName)
        return inputCarName.split(NAME_DIVISION_NOTATION).map { it.trim() }
    }

    fun inputExecutionNumber(): Int {
        val inputExecutionNum = Console.readLine()
        exception.wrongNumException(inputExecutionNum)
        return inputExecutionNum.toInt()
    }
}
