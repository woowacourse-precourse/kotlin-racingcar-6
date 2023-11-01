package racingcar

import camp.nextstep.edu.missionutils.Console
import kotlin.IllegalArgumentException

class InputManager {
    private var tryTime = 0
    fun getCarName(): MutableList<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)) 기준으로 구분")
        val inputLine = Console.readLine()

        if (inputLine.contains(" ")) {
            throw IllegalArgumentException("")
        }

        return inputLine.split(",").toMutableList()
    }

    fun getTryTime(): Int {
        println("시도할 횟수는 몇 회인가요?")
        tryTime = Console.readLine().toInt()
        checkTryTime()
        return tryTime
    }
    private fun checkTryTime() {
        if(tryTime is Int) {
            return;
        }
        else{
            throw IllegalArgumentException("")
        }
    }

}