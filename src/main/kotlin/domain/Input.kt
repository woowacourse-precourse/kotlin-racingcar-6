package domain

import camp.nextstep.edu.missionutils.Console
import domain.Constant.NAME_DIVISION_NOTATION

class Input {
    fun inputName(): List<String> {
        val inputCarName = Console.readLine()
        // 결과 확인을 위한 예시 출력
        // println(inputCarName)
        // println(carName)
        return inputCarName.split(NAME_DIVISION_NOTATION).map { it.trim() }
    }

    fun inputExecutionNumber(): Int {
        val inputExecutionNum = Console.readLine()
        // 입력 수 예외처리 해주기
        return inputExecutionNum.toInt()
    }
}
