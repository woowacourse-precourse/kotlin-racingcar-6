package racingcar

import camp.nextstep.edu.missionutils.Console

object InputManager {
    fun getCarNames() : List<String> {
        println(Resources.PLEASE_ENTER_THE_NAMES_OF_CARS)
        val input = Console.readLine()
        return input.split(",").map {
            require(it.length <= 5) {"Wrong Car name! Car name must be 5 characters or less"}
            it
        }
    }
    fun getRoundNum(): Int{
        println(Resources.HOW_MANY_ATTEMPTS)
        return Console.readLine().toInt()
    }
}
