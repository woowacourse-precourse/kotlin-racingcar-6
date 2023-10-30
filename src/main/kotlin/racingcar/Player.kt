package racingcar

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class Player {
    fun inputCarName(): String {
        return Console.readLine()
    }

    fun inputNumberOfAttempt(): Int {
        return try {
            Console.readLine().toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException("숫자만 입력해 주세요.")
        }
    }

}