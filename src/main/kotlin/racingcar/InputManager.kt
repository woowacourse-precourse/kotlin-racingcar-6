package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

const val INPUT_CAR = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
const val INPUT_EXECUTION_NUMBER = "시도할 횟수는 몇 회인가요?"

object InputManager {
    fun inputCar(): String {
        println(INPUT_CAR)
        return readLine()
    }

    fun inputExecutionNumber(): Int {
        println(INPUT_EXECUTION_NUMBER)

        val executionNumberString = readLine()
        return executionNumberString.toInt()
    }
}