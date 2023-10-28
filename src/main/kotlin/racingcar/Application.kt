package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car

val carList = mutableListOf<Car>()

fun main() {
    enterCarName()
}

fun enterCarName() {
    println(Const.ENTER_CAR_NAME_MSG)
    val carNameList = Console.readLine().split(",")
    validateCarName(carNameList)
    makeCar(carNameList)
}

fun validateCarName(carNameList: List<String>) {
    carNameList.map { name ->
        if (name.length > 5) throw IllegalArgumentException(Const.EXCEPTION_INPUT_RANGE_OVERFLOW)
    }
}

fun makeCar(carNameList: List<String>) {
    carNameList.map { name ->
        carList.add(Car(_name = name))
    }
}