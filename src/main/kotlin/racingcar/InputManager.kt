package racingcar

import camp.nextstep.edu.missionutils.Console

object InputManager {
    fun getCarNames() : List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine()
        return input.split(",").map {
            require(it.length <= 5) {"Wrong Car name! Car name must be 5 characters or less"}
            it
        }
    }
    fun getRoundNum(): Int{
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine().toInt()
    }
}
