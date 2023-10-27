package racingcar

import camp.nextstep.edu.missionutils.Console
import java.util.StringTokenizer

class UserInputManager {
    fun userNameInput() : MutableList<String>{
        val nameList = mutableListOf<String>()
        val input = Console.readLine()
        val st = StringTokenizer(input, ",")
        while(st.hasMoreTokens()) {
            nameList.add(st.nextToken())
        }
        return nameList
    }
}