package domain

import camp.nextstep.edu.missionutils.Console
import domain.Constant.INPUT_CAR_NAME_TEXT
import domain.Constant.NAME_DIVISION_NOTATION

class Car {
    fun printName() {
        println(INPUT_CAR_NAME_TEXT)

    }
    fun inputName(): List<String> {
        val inputCarName = Console.readLine()
        // 결과 확인을 위한 예시 출력
        // println(inputCarName)
        // println(carName)
        return inputCarName.split(NAME_DIVISION_NOTATION)
    }
}
