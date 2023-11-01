package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.res.EXCEPTION_DEFAULT
import racingcar.res.EXCEPTION_USER_NAME
import java.lang.Exception

object InputVerification {
    fun getCarNames(): List<String>{
        val input = Console.readLine().split(",")
        return verifyEachNameLength(input)
    }

    fun getTryNumber(): Int {
        return try {
            Console.readLine().toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException(EXCEPTION_DEFAULT)
        }
    }

    private fun verifyEachNameLength(input: List<String>): List<String> {
        input.forEach {
            if (it.length > 5) throw IllegalArgumentException(EXCEPTION_USER_NAME)
        }
        return input
    }
}