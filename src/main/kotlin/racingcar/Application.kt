package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car

val carList = mutableListOf<Car>()

fun main() {
    enterCarName()
}

fun enterCarName() {
    println(Const.ENTER_CAR_NAME_MSG)
    val inputCarNames = Console.readLine()
    validateCarName(inputCarNames)
    //makeCar(Console.readLine())
}

fun validateCarName(inputCarNames: String) {
    val nameList = inputCarNames.split(",")
    nameList.map { name ->
        if (name.length > 5) throw IllegalArgumentException(Const.EXCEPTION_INPUT_RANGE_OVERFLOW)
    }
}
