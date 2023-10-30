package racingcar

import camp.nextstep.edu.missionutils.Console

class Player {
    fun inputCarName(): String {
        return Console.readLine()
    }

    fun inputNumberOfAttempt(): Int {
        return Console.readLine().toInt()
    }

}