package racingcar

import camp.nextstep.edu.missionutils.Console

class InputManager {
    val exceptionManager = ExceptionManager()
    fun readCarName(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine()

        val nameList = input.split(",")
        exceptionManager.nameException(nameList)

        return nameList
    }

    fun readRepeatNum(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine()
        exceptionManager.repeatException(input)

        println()
        println("실행 결과")
        return input.toInt()
    }
}