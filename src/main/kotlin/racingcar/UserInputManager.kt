package racingcar

import camp.nextstep.edu.missionutils.Console
import java.util.StringTokenizer

class UserInputManager {
    private val userInputValidator = UserInputValidator()
    fun userNameInput() : MutableList<String>{
        val nameList = mutableListOf<String>()
        val input = Console.readLine()
        val st = StringTokenizer(input, ",")
        while(st.hasMoreTokens()) {
            nameList.add(st.nextToken())
        }
        userInputValidator.userNameInputValidator(nameList)
        return nameList
    }

    fun userTryCountInput() : Int{
        val input = Console.readLine()
        userInputValidator.userTryCountInputValidator(input)
        return input.toInt()
    }
}