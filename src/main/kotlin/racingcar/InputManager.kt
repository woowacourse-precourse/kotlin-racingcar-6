package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

const val INPUT_CAR = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"

object InputManager {
    fun inputCar(): String {
        println(INPUT_CAR)
        return readLine()
    }
}