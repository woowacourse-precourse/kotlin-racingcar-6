package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car

val carList = mutableListOf<Car>()

fun main() {
    val carNameList = enterCarName()
    validateCarNameLength(carNameList)
    validateCarNameDistinct(carNameList)
    makeCar(carNameList)
    doGame(enterTryCnt())
    showWinner()
}

fun enterCarName(): List<String> {
    println(Const.ENTER_CAR_NAME_MSG)
    return Console.readLine().split(",")
}

fun validateCarNameLength(carNameList: List<String>) {
    carNameList.forEach { name ->
        if ((name.trim().length in 1..5).not()) throw IllegalArgumentException(Const.EXCEPTION_CAR_NAME_LENGTH_INVALIDATE)
    }
}

fun validateCarNameDistinct(carNameList: List<String>) {
    if (carNameList.distinct().size != carNameList.size) throw IllegalArgumentException(Const.EXCEPTION_CAR_NAME_DUPLICATED)
}

fun makeCar(carNameList: List<String>) {
    carList.addAll(
        carNameList.map { name ->
            Car(_name = name.trim())
        }
    )
}

fun enterTryCnt(): Int {
    println(Const.ENTER_TRY_CNT_MSG)
    Console.readLine().toIntOrNull()?.let { tryCnt ->
        return tryCnt
    }
    throw IllegalArgumentException(Const.EXCEPTION_TRY_CNT_NOT_INT)
}

fun doGame(userInputTryCnt: Int) {
    println()
    println(Const.GAME_RESULT_MSG)
    var currentGameTryCnt = 0
    while (currentGameTryCnt < userInputTryCnt) {
        carList.forEach { car ->
            car.moveForward()
        }
        println()
        currentGameTryCnt++
    }
}

fun showWinner() {
    carList.maxOfOrNull { it.forwardCnt }?.let { maxForwardCnt ->
        val winner = carList.filter { car ->
            car.forwardCnt == maxForwardCnt
        }.joinToString { it.name }
        println(Const.GAME_WINNER_MSG + winner)
    }
}