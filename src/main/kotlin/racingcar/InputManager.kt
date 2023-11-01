package racingcar

import camp.nextstep.edu.missionutils.Console

object InputManager {
    fun getCarNames(): List<String> {
        println(Resources.PLEASE_ENTER_THE_NAMES_OF_CARS)
        val input = Console.readLine()
        require(input.isNotEmpty()) { "Wrong Car name! You must input something" }
        return input.split(",").map {
            require(it.length <= 5) { "Wrong Car name! Car name must be 5 characters or less" }
            it
        }
    }
    fun getRoundNum(): Int {
        println(Resources.HOW_MANY_ATTEMPTS)
        val roundNum = Console.readLine().toInt()
        require(roundNum >= 0) { "Round number must be 0 or positive" }
        return roundNum
    }
}
