package racingcar

import camp.nextstep.edu.missionutils.Console

class Input {

    fun inputCar(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val inputString = Console.readLine()
        return makeCar(inputString)
    }
}