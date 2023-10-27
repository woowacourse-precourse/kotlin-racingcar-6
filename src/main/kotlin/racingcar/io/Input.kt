package racingcar.io

import camp.nextstep.edu.missionutils.Console
import racingcar.util.toCarNameList

fun inputRacingCars(): List<String> {
    val racingCars = Console.readLine()
    return racingCars.toCarNameList()
}

fun inputTryCount(): String {
    return Console.readLine()
}