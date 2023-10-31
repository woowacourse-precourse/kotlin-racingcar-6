package racingcar.domain

import camp.nextstep.edu.missionutils.Console

class User {
    companion object {
        val name = inputName()
        val nameList = name?.split(",")
        val resultName = nameList?.joinToString(",")
        val tryNum = inputTry()
    }
}

fun inputName(): String? {
    return Console.readLine()
}

fun inputTry(): Int {
    return Console.readLine().toInt()
}