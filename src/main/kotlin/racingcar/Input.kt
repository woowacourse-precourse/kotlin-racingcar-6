package racingcar

import camp.nextstep.edu.missionutils.Console

class Input {

    fun carInput(): String {
        return inputCar()
    }

    fun attemptInput(): Int {
        return inputAttempt()
    }

    private fun inputCar(): String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val inputString = Console.readLine()
        return inputString
    }

    private fun inputAttempt(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val inputInt = Console.readLine()
        Validation().attemptValidation(inputInt)
        return inputInt.toInt()
    }
}