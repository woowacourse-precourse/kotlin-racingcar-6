package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.NumberFormatException

class Racing {

    fun enterMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val moveCount = Console.readLine()
        return try {
            moveCount!!.toInt()
        } catch (e: NumberFormatException){
            throw IllegalArgumentException("정수를 입력해 주세요.")
        }
    }
}