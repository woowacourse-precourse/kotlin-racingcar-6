package racingcar.domain

import camp.nextstep.edu.missionutils.Console

class User {
    companion object {
        val name = inputName()
        val nameList = name?.split(",")
        val carNum = nameList?.size
        val resultName = nameList?.joinToString(",")
        val tryNum = inputTrial()
    }
}

fun inputName(): String? {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return Console.readLine()
}

fun inputTrial(): Int {
    println("시도할 횟수는 몇 회인가요?")
    var num = Console.readLine()
    var result = inputTrialValidation(num)
    return result
}

fun inputTrialValidation(num: String): Int {
    val result: Int
    try {
        result = num.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("문자가 아닌 숫자를 입력하세요.")
    }
    return result
}