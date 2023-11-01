package domain

import camp.nextstep.edu.missionutils.Console
import domain.Constant.INPUT_TRY_NUM_TEXT

class Racing {
    fun printRacing() {
        println(INPUT_TRY_NUM_TEXT)
    }
    fun inputExecutionNumber(): Int {
        val inputExecutionNum = Console.readLine()
        // 입력 수 예외처리 해주기
        return inputExecutionNum.toInt()
    }
}