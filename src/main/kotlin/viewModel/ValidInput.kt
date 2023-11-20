package viewModel

import camp.nextstep.edu.missionutils.Console
import errorMessage.InputError.*
import racingcar.Racing.GameConstants.limitLength

class ValidInput {
    fun validInputGameCount():Int {
        val gameCount = Console.readLine()
        if (gameCount.toIntOrNull() == null) {
            throw IllegalArgumentException(NOT_DIGIT.message)
        }
        return gameCount.toInt()
    }
    fun validName(carName:List<String>):Boolean{
        if(carName.any { it.length > limitLength }){
            throw IllegalArgumentException(OVER_FIVE.message)
        }
        return true
    }
}