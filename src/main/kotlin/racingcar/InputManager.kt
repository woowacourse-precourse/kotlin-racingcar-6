package racingcar

import camp.nextstep.edu.missionutils.Console

class InputManager {
    fun readCarName(): List<String> {
        println("이름을 입력하세요:")
        val input = Console.readLine()

        return input.split(",")
    }

    fun readRepeatNum(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine()
        return input.toInt()
    }
}