package racingcar

import camp.nextstep.edu.missionutils.Console

class Racing {

    fun enterMoveCount(): String {
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine()
    }
}