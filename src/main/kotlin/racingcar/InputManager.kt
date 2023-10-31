package racingcar

import camp.nextstep.edu.missionutils.Console
import kotlin.IllegalArgumentException

class InputManager {
    fun getCarName(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)) 기준으로 구분")
        val inputLine = Console.readLine()

        if (inputLine.contains(" ")) {
            throw IllegalArgumentException("")
        }

        return inputLine.split(",")
    }

    fun getTryTime(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val count = Console.readLine().toInt()
        return count
    }

}