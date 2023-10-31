package racingcar.io

import camp.nextstep.edu.missionutils.Console
import racingcar.constants.Output

fun inputRacingCarsName(): String {
    println(Output.CAR_INPUT)
    return Console.readLine()
}

fun inputTryCount(): String {
    println(Output.TRY_INPUT)
    return Console.readLine()
}