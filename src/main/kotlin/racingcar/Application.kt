package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car

val carList = mutableListOf<Car>()

fun main() {
    enterCarName()
    var currentGameTryCnt = 0
    val userInputTryCnt = enterTryCnt()
    while (currentGameTryCnt <= userInputTryCnt) {
        carList.map { car ->
            car.moveForward()
        }
        println()
        currentGameTryCnt++
    }
}

fun enterCarName() {
    println(Const.ENTER_CAR_NAME_MSG)
    val carNameList = Console.readLine().split(",")
    validateCarName(carNameList)
    makeCar(carNameList)
}

fun validateCarName(carNameList: List<String>) {
    carNameList.map { name ->
        if (name.trim().length > 5) throw IllegalArgumentException(Const.EXCEPTION_INPUT_RANGE_OVERFLOW)
    }
}

fun makeCar(carNameList: List<String>) {
    carNameList.map { name ->
        carList.add(Car(_name = name.trim()))
    }
}

fun enterTryCnt(): Int {
    println(Const.ENTER_TRY_CNT_MSG)
    Console.readLine().toIntOrNull()?.let { tryCnt ->
        return tryCnt
    }
    throw IllegalArgumentException(Const.EXCEPTION_INPUT_NOT_INT)
}